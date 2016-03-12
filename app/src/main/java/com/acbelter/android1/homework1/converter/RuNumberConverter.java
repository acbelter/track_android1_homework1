package com.acbelter.android1.homework1.converter;

public class RuNumberConverter extends AbstractNumberConverter {
    private static final String ZERO = "ноль";
    private static final String MINUS = "минус";

    private static final String[][] FIRST_DECADE = {
            {"", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
    };

    private static final String[] SECOND_DECADE = {"", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать", "двадцать"};

    private static final String[] DECADES = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят",
            "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};

    private static final String[] HUNDREDS = {"", "сто", "двести", "триста", "четыреста", "пятьсот",
            "шестьсот", "семьсот", "восемьсот", "девятьсот"};

    private static final String[][] FORMS = {
            {"", "", "", "1"},
            {"тысяча", "тысячи", "тысяч", "0"},
            {"миллион", "миллиона", "миллионов", "1"},
            {"миллиард", "миллиарда", "миллиардов", "1"},
    };

    @Override
    protected String getMinusStringForm() {
        return MINUS;
    }

    @Override
    protected String getZeroStringForm() {
        return ZERO;
    }

    @Override
    protected String getFirstDecadeStringForm(int index, int gender) {
        return FIRST_DECADE[gender][index];
    }

    @Override
    protected String getSecondDecadeStringForm(int index) {
        return SECOND_DECADE[index];
    }

    @Override
    protected String getDecadesStringForm(int index) {
        return DECADES[index];
    }

    @Override
    protected String getHundredsStringForm(int index) {
        return HUNDREDS[index];
    }

    @Override
    protected int getTriadGender(int triadIndex) {
        return Integer.valueOf(FORMS[triadIndex][3]);
    }

    @Override
    protected String getTriadName(int triadIndex, int triadValue) {
        if (triadValue % 100 > 4 && triadValue % 100 < 21) {
            return FORMS[triadIndex][2];
        }

        switch (triadValue % 10) {
            case 1:
                return FORMS[triadIndex][0];
            case 2:
            case 3:
            case 4:
                return FORMS[triadIndex][1];
            default:
                return FORMS[triadIndex][2];
        }
    }
}