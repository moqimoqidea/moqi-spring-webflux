package com.moqi.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author moqi
 * @date 4/20/22 23:10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Greeting {

    private String message;

}
