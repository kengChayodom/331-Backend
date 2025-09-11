package se331.lab.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import se331.lab.entity.Event;
import se331.lab.entity.Organization;
import se331.lab.repository.EventRepository;
import se331.lab.repository.OrganizeRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {

    private final EventRepository eventRepository;
    private final OrganizeRepository organizeRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .organizer("CAMT")
                .build());

        // Create and save a "Commencement Day" event
        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .organizer("CMU")
                .build());

        // Create and save a "Loy Krathong" event
        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .organizer("Chiang Mai")
                .build());

        // Create and save a "Songkran" event
        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am-6.00 pm.")
                .petAllowed(true)
                .organizer("Chiang Mai Municipality")
                .build());


        organizeRepository.save(Organization.builder()
                .organization_Name("CAMT")
                .address("123 A Street")
                .build());

        organizeRepository.save(Organization.builder()
                .organization_Name("CMU")
                .address("456 B Avenue")
                .build());

        organizeRepository.save(Organization.builder()
                .organization_Name("Chiang Mai")
                .address("789 C Road")
                .build());

        organizeRepository.save(Organization.builder()
                .organization_Name("Chiang Mai Municipality")
                .address("101 D Lane")
                .build());
    }






}