package ma.payflow.payment_engine.mapper;

import ma.payflow.payment_engine.domain.Client;
import ma.payflow.payment_engine.dto.ClientRequestDTO;
import ma.payflow.payment_engine.dto.ClientResponseDTO;
import org.mapstruct.Mapper;

/**
 * @author Asmae
 **/
@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toEntity(ClientRequestDTO clientRequestDTO);
    ClientResponseDTO toResponse(Client client);
}