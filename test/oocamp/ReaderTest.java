package oocamp;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * 10m / 2 + 5cm * 4 - 20mm
 */

public class ReaderTest {

    private Reader reader;

    @Before
    public void setUp() throws Exception {
        reader = new Reader();
    }

    @Test
    public void should_find_a_number_successfully_if_input_starts_with_number() throws Exception {
        assertThat(reader.findNumber("123abc").getValue()).isEqualTo(123);
    }

    @Test
    public void should_not_find_a_number_if_input_is_not_start_with_a_number() throws Exception {
        assertThat(reader.findNumber("a123")).isEqualTo(null);
    }

    @Test
    public void should_found_operators_successfully_if_input_starts_with_operators() throws Exception {
        assertThat(reader.findOperator("+11")).isEqualTo(Operator.plus);
        assertThat(reader.findOperator("-22")).isEqualTo(Operator.minus);
        assertThat(reader.findOperator("*33")).isEqualTo(Operator.multiply);
        assertThat(reader.findOperator("/44")).isEqualTo(Operator.div);
    }

    @Test
    public void should_not_found_operators_successfully_if_input_not_start_with_operators() throws Exception {
        assertThat(reader.findOperator("1+")).isEqualTo(null);
    }

    @Test
    public void should_found_number_with_m_successfully_if_input_starts_with_number_and_m() throws Exception {
        NumberWithUnit numberWithUnit = reader.findNumWithUnit("10m+++");
        assertThat(numberWithUnit.getNumber()).isEqualTo(10);
        assertThat(numberWithUnit.getUnit()).isEqualTo(Unit.m);
    }

    @Test
    public void should_not_found_number_with_m_successfully_if_input_starts_with_number_and_m() throws Exception {
        NumberWithUnit numberWithUnit = reader.findNumWithUnit("10+++");
        assertThat(numberWithUnit).isNull();
    }

    @Test
    public void should_found_number_with_mm_successfully_if_input_starts_with_number_and_mm() throws Exception {
        NumberWithUnit numberWithUnit = reader.findNumWithUnit("10mm+++");
        assertThat(numberWithUnit.getNumber()).isEqualTo(10);
        assertThat(numberWithUnit.getUnit()).isEqualTo(Unit.mm);
    }

    @Test
    public void should_not_found_number_with_mm_successfully_if_input_starts_with_number_and_mm() throws Exception {
        NumberWithUnit numberWithUnit = reader.findNumWithUnit("10+++");
        assertThat(numberWithUnit).isNull();
    }


    @Test
    public void should_found_number_with_cm_successfully_if_input_starts_with_number_and_cm() throws Exception {
        NumberWithUnit numberWithUnit = reader.findNumWithUnit("10cm+++");
        assertThat(numberWithUnit.getNumber()).isEqualTo(10);
        assertThat(numberWithUnit.getUnit()).isEqualTo(Unit.cm);
    }

    @Test
    public void should_not_found_number_with_cm_successfully_if_input_starts_with_number_and_cm() throws Exception {
        NumberWithUnit numberWithUnit = reader.findNumWithUnit("10+++");
        assertThat(numberWithUnit).isNull();
    }

    @Test
    public void should_read_whole_expression_successfully() throws Exception {
        List<Token> tokens = reader.read("10m / 2 + 5cm * 4 - 20mm");
        assertThat(tokens).isEqualTo(Lists.newArrayList(
                new NumberWithUnit(10, Unit.m),
                Operator.div,
                new Number(2),
                Operator.plus,
                new NumberWithUnit(5, Unit.cm),
                Operator.multiply,
                new Number(4),
                Operator.minus,
                new NumberWithUnit(20, Unit.mm)
        ));
    }
}
