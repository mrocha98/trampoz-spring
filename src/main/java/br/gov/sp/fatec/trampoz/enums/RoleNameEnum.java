package br.gov.sp.fatec.trampoz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum RoleNameEnum {
    ADMIN("ADMIN"),
    FREELANCER("FREELANCER"),
    COMPANY("COMPANY");

    @Getter
    private final String value;
}
