package api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

public class Brand {
    @NotNull
    @JsonProperty
    private Long id;

    @NotNull
    @JsonProperty
    private String name;

    public Brand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Brand() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
