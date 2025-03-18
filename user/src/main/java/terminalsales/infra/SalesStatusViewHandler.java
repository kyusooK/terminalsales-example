package terminalsales.infra;

import terminalsales.domain.*;
import terminalsales.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class SalesStatusViewHandler {

//<<< DDD / CQRS
    @Autowired
    private SalesStatusRepository salesStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void when_then_CREATE_ (@Payload  ) {
        try {

            if (!.validate()) return;

            // view 객체 생성
            SalesStatus salesStatus = new SalesStatus();
            // view 객체에 이벤트의 Value 를 set 함
            salesStatus.setProductId(.getProductId());
            salesStatus.setOrderId(.getId());
            salesStatus.setInsurance(Boolean.valueOf(.getInsuranceOption()));
            // view 레파지 토리에 save
            salesStatusRepository.save(salesStatus);

        }catch (Exception e){
            e.printStackTrace();
        }
    }




//>>> DDD / CQRS
}

