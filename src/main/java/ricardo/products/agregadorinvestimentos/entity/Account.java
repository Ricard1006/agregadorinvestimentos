package ricardo.products.agregadorinvestimentos.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @Column(name = "account_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID acountId;

    @Column(name = "description")
    private String description;

    public Account() {
    }

    public Account(UUID acountId, String description) {
        this.acountId = acountId;
        this.description = description;
    }

    public UUID getAcountId() {
        return acountId;
    }

    public void setAcountId(UUID acountId) {
        this.acountId = acountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
