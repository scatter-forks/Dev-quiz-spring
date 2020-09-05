package com.thoughtworks.rslist.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    @NotNull
    private String category;
    @NotNull
    private String name;
    @NotNull
    private Integer price;
    @NotNull
    private String unit;
    @NotNull
    private String imgUrl;
}