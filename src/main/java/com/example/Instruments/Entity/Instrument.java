package com.example.Instruments.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: Instruments
 * @description:
 * @author: Siyu Hou
 * @create: 2023-06-17 16:02
 **/
@Getter
@Setter
@Entity
public class Instrument {
    @Id
    Integer id;
    String name;
    String info;
}
