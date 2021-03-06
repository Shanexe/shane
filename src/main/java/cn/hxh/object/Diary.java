package cn.hxh.object;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Diary {
    @JsonProperty
    @Valid
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Key date;
    @JsonProperty
    @Valid
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<Item> items;
    @JsonProperty
    @Length(max = 1000)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String extend;

    @Getter
    @Setter
    static class Item {
        @JsonProperty
        @Min(0)
        @Max(24)
        short start;
        @JsonProperty
        @Min(0)
        @Max(24)
        short end;
        @JsonProperty
        @Length(min = 1, max = 100)
        @NotNull
        String content;
    }

    @Getter
    @Setter
    public static class Key {
        @JsonProperty
        @Min(2018)
        @Max(2030)
        int year;
        @Min(1)
        @Max(12)
        @JsonProperty
        int month;
        @Min(1)
        @Max(31)
        @JsonProperty
        int date;

        public Key() {

        }

        public Key(int year, int month, int date) {
            this.year = year;
            this.month = month;
            this.date = date;
        }


        @Override
        public String toString() {
            return String.format("%s-%s-%s", year, month, date);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return year == key.year &&
                    month == key.month &&
                    date == key.date;
        }

        @Override
        public int hashCode() {
            return Objects.hash(year, month, date);
        }
    }
}
