package terminalsales.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import terminalsales.MarketingApplication;
import terminalsales.domain.DiscountPolicyActivated;

@Entity
@Table(name = "Retargetting_table")
@Data
//<<< DDD / Aggregate Root
public class Retargetting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String productId;

    private Integer returnCount;

    public static RetargettingRepository repository() {
        RetargettingRepository retargettingRepository = MarketingApplication.applicationContext.getBean(
            RetargettingRepository.class
        );
        return retargettingRepository;
    }
}
//>>> DDD / Aggregate Root
