package com.projecthope.news.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Builder
@Entity
@Table(name = "NEWS")
@NoArgsConstructor
@AllArgsConstructor
public class News {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "NEWS_SEQ_GEN")
    @SequenceGenerator(name = "NEWS_SEQ_GEN", sequenceName = "NEWS_SEQ", allocationSize = 1)
    private Long id;
    private String header;
    private String body;
    private String picture;
    private String lastModified; // Use hibernate automatic time updater

}