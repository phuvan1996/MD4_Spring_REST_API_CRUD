package ra.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private int productId;
    @Column(name = "ProductName",columnDefinition = "nvarchar(50)",nullable = false,unique = true)
    private String productName;
    @Column(name = "price")
    private double price;
    @Column(name = "description")
    private String description;
    @Column(name = "CreateDate")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date createDate;
    @Column(name = "Status")
    private boolean status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "catalogId")
    private Catalog catalog;
}
