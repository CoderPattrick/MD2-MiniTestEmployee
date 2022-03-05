package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private final String regexID="^[fp]\\d{1,}";
    private final String regexPhone="^0\\d{9,}";
    private final String regexName="[a-zA-Z\s]";
    private final String regexAge="\\d{1,3}";
    private final String regexBonus="\\d{0,10000}";
    private final String regexMinus="\\d{0,10000}";
    private final String regexBaseSalary="\\d{1000,}";
    private final String regexWorkHour="\\d{12,48}";
    private final String regexMail="^[\\w]+[\\w]*@[\\w]+(\\.[\\w]+)$";

    public boolean isValidId(String id){
        Pattern p = Pattern.compile(regexID);
        Matcher m = p.matcher(id);
        return m.matches();
    }
    public boolean isValidName(String name){
        Pattern p = Pattern.compile(regexName);
        Matcher m = p.matcher(name);
        return m.matches();
    }
    public boolean isValidAge(String age){
        Pattern p = Pattern.compile(regexAge);
        Matcher m = p.matcher(age);
        return m.matches();
    }
    public boolean isValidPhone(String phone){
        Pattern p = Pattern.compile(regexPhone);
        Matcher m = p.matcher(phone);
        return m.matches();
    }
    public boolean isValidMail(String mail){
        Pattern p = Pattern.compile(regexMail);
        Matcher m = p.matcher(mail);
        return m.matches();
    }
    public boolean isValidBonus(String bonus){
        Pattern p = Pattern.compile(regexBonus);
        Matcher m = p.matcher(bonus);
        return m.matches();
    }
    public boolean isValidMinus(String minus){
        Pattern p = Pattern.compile(regexMinus);
        Matcher m = p.matcher(minus);
        return m.matches();
    }
    public boolean isValidBase(String base){
        Pattern p = Pattern.compile(regexBaseSalary);
        Matcher m = p.matcher(base);
        return m.matches();
    }
    public boolean isValidWorkHour(String workHour){
        Pattern p = Pattern.compile(regexWorkHour);
        Matcher m = p.matcher(workHour);
        return m.matches();
    }
}
