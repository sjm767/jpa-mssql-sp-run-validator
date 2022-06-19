package com.sample.jpa.code.gen.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
        name = User.SPName,
        procedureName = "dbo."+ User.SPName,
        resultClasses = User.class,
        parameters = {
            @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN), //@id
            @StoredProcedureParameter(type = String.class, mode = ParameterMode.IN) //@username
        }
    ),
    @NamedStoredProcedureQuery(
        name = User.SPInsertName,
        procedureName = "dbo."+ User.SPInsertName,
        resultClasses = User.class,
        parameters = {
            @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN), //@id
            @StoredProcedureParameter(type = String.class, mode = ParameterMode.IN), //@username
            @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN) //@age
        }
    ),
    @NamedStoredProcedureQuery(
        name = User.SPUpdateName,
        procedureName = "dbo."+ User.SPUpdateName,
        resultClasses = User.class,
        parameters = {
            @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN), //@id
            @StoredProcedureParameter(type = String.class, mode = ParameterMode.IN), //@username
            @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN) //@age
        }
    ),
    @NamedStoredProcedureQuery(
        name = User.SPDeleteName,
        procedureName = "dbo."+ User.SPDeleteName,
        resultClasses = User.class,
        parameters = {
            @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN) //@id
        }
    )
})
public class User {

    public final static String SPName = "sample_codegen_select";

    public final static String SPInsertName = "sample_codegen_insert";

    public final static String SPUpdateName = "sample_codegen_update";

    public final static String SPDeleteName = "sample_codegen_delete";

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "AGE")
    private Integer age;


    //==생성 메서드==//
    public static User createUser(Integer id, String username, Integer age) {

        User user = User.builder()
            .id(id)
            .username(username)
            .age(age)
            .build();

        return user;
    }

}