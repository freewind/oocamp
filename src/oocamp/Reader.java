package oocamp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {

    public Number findNumber(String input) {
        List<String> found = findByRegex("^(\\d+)", input);
        if (!found.isEmpty()) {
            return new Number(Integer.parseInt(found.get(0)));
        }
        return null;
    }

    public Operator findOperator(String operator) {
        List<String> found = findByRegex("^([-+*/])", operator);
        if (!found.isEmpty()) {
            return Operator.from(found.get(0).charAt(0));
        }
        return null;
    }

    public NumberWithUnit findNumWithUnit(String input) {
        List<String> found = findByRegex("^(\\d+)(cm|mm|m)", input);
        if (!found.isEmpty()) {
            int number = Integer.parseInt(found.get(0));
            String unit = found.get(1);
            return new NumberWithUnit(number, Unit.valueOf(unit));
        }
        return null;
    }

    private List<String> findByRegex(String patternStr, String input) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(input);

        List<String> found = new ArrayList<String>();
        if (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                found.add(matcher.group(i));
            }
        }
        return found;
    }

    public List<Token> read(String input) {
        //"10m / 2 + 5cm * 4 - 20mm"
        String units = input.trim();
        ArrayList<Token> tokens = new ArrayList<Token>();





        return null;
    }
}
