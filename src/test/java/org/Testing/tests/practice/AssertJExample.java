package org.Testing.tests.practice;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExample {

    public static void main(String[] args) {
        String response_name ="Ishu";
        assertThat(response_name).isNotNull().isNotBlank().isEqualTo("Ishu");
    }
}
