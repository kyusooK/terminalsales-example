package terminalsales.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import terminalsales.domain.*;
import terminalsales.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class UserRegistered extends AbstractEvent {

    private Long id;
    private String name;
    private String region;
    private String gender;

    public UserRegistered(User aggregate) {
        super(aggregate);
    }

    public UserRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
