package ro.bulimac.vlad.queueexample.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author vladclaudiubulimac on 17/02/2018.
 */

@Builder
@ToString
@Data
public class Email{

    private Long id;
    private String to;
    private String from;
    private String cc;
    private String subject;
    private String body;

}
