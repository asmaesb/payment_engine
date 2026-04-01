package ma.payflow.payment_engine.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Asmae
 **/
@Data
public class PageResponseDTO<T> {
    private List<T> content;
    private int currentPage;
    private int totalPages;
    private long totalElements;
}