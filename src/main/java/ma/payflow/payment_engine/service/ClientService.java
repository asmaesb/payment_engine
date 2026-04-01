package ma.payflow.payment_engine.service;

import lombok.RequiredArgsConstructor;
import ma.payflow.payment_engine.exception.CustomException;
import ma.payflow.payment_engine.domain.Client;
import ma.payflow.payment_engine.dto.ClientRequestDTO;
import ma.payflow.payment_engine.dto.ClientResponseDTO;
import ma.payflow.payment_engine.dto.PageResponseDTO;
import ma.payflow.payment_engine.enums.ClientStatus;
import ma.payflow.payment_engine.mapper.ClientMapper;
import ma.payflow.payment_engine.repository.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author Asmae
 **/
@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Transactional
    public ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO){

        clientRepository.findByIdentificationTypeAndIdentificationNumber(clientRequestDTO.getIdentificationType(),
                clientRequestDTO.getIdentificationNumber()).ifPresent(existingClient -> {
            if (!existingClient.getClientStatus().equals(ClientStatus.INACTIVE)) {
                throw new CustomException("Client already exists");
            }
        });

        Client client =  clientMapper.toEntity(clientRequestDTO);
        String branchCode = "666";
        client.setBranchCode(branchCode);
        client.setClientNumber(generateClientNumber(branchCode,clientRequestDTO.getClientType().getValue()));
        client.setClientStatus(ClientStatus.AWAITING_VALIDATION);

        Client savedClient = clientRepository.save(client);
        return clientMapper.toResponse(savedClient);
    }

    @Transactional(readOnly = true)
    public PageResponseDTO<ClientResponseDTO> getClientsByStatus(ClientStatus status, Pageable pageable){
        Page<Client> clientPage = clientRepository.findByClientStatus(status,pageable );
        Page<ClientResponseDTO> dtoPage = clientPage.map(clientMapper::toResponse);
        PageResponseDTO<ClientResponseDTO> pageResponse = new PageResponseDTO<>();
        pageResponse.setContent(dtoPage.getContent());
        pageResponse.setCurrentPage(dtoPage.getNumber());
        pageResponse.setTotalPages(dtoPage.getTotalPages());
        pageResponse.setTotalElements(dtoPage.getTotalElements());
        return pageResponse;
    }

    @Transactional(readOnly = true)
    public ClientResponseDTO getClient(String clientNumber){

       Client client = clientRepository.findById(clientNumber).
               orElseThrow(() -> new CustomException("Client not found"));
        return clientMapper.toResponse(client);
    }

    @Transactional
    public ClientResponseDTO validateClient(String clientNumber){
        // TODO : should only fetch it if the client branch code and the logged user branch code are the same
        Client client = clientRepository.findById(clientNumber).
                orElseThrow(() -> new CustomException("Client not found"));
        if (client.getClientStatus().equals(ClientStatus.AWAITING_VALIDATION))
            client.setClientStatus(ClientStatus.ACTIVE);
        else
            throw new CustomException("Client is not awaiting validation, cannot be activated");
        return clientMapper.toResponse(clientRepository.save(client));
    }

    private String generateClientNumber(String bankCode, String clientType) {
        return bankCode +
                clientType +
                String.format("%05d", clientRepository.generateClientNumber());
    }

}
