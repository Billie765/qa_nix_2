package org.example;

import java.util.Arrays;

public class MathSet {

    private int size;
    private Number[] numbers;

    public MathSet() {
        this.size = 10;
        this.numbers = new Number[size];
    }

    public MathSet(int size) {
        this.size = size;
        this.numbers = new Number[size];
    }

    public MathSet(Number[] numbers) {
        this.size = numbers.length;
        this.numbers = getUniqueValues(numbers);
    }

    public MathSet(Number[]... numbers) {
        Number[] allNumbers = joinArrays(numbers);
        this.numbers = getUniqueValues(allNumbers);
    }

    public MathSet(MathSet numbers) {
        this.numbers = numbers.getNumbers();
    }

    public MathSet(MathSet... numbers) {
        this.numbers = joinSets(numbers);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Number[] getNumbers() {
        return numbers;
    }

    public void setNumbers(Number[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "MathSet{" +
                "size=" + size +
                ", numbers=" + Arrays.toString(numbers) +
                '}';
    }

    private boolean isInSet(Number item, Number[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == item) {
               return true;
            }
        }
        return false;
    }
    public void add(Number n) {
        Number[] temp = this.numbers;
        int position = 0;
        if (!(isInSet(n, temp))) {
            if (temp[size - 1] != null) {
                position = size;
                increaseSet();
                this.numbers[position] = n;
            } else {
                for (int i = 0; i < size; i++) {
                    if (temp[i] != null) {
                        position++;
                    }
                }
                temp[position] = n;
            }
        }
    }

    public void add(Number... n) {
        for (Number number : n) {
            add(number);
        }
    }

    public void join(MathSet ms) {
        this.numbers = joinSets(this, ms);
    }

    public void join(MathSet... ms) {
        for (MathSet temp : ms) {
            this.numbers = joinSets(this, temp);
        }
    }

    public void intersection(MathSet ms) {
        if (this.getNumbers().length >= ms.getNumbers().length) {
            this.setNumbers(intersect(ms, this));
        } else {
            this.setNumbers(intersect(this, ms));
        }
    }

    public void intersection(MathSet... ms) {
        for (MathSet temp : ms) {
            if (this.getNumbers().length >= temp.getNumbers().length) {
                this.setNumbers(intersect(temp, this));
            } else {
                this.setNumbers(intersect(this, temp));
            }
        }
    }

    void sortDesc() {
        Number temp;
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i; j > 0; j--) {
                if (!(numbers[j] == null) && numbers[j].doubleValue() > numbers[j - 1].doubleValue()) {
                    temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }
            }
        }
    }

    void sortDesc(int firstIndex, int lastIndex) {
        Number temp;
        for (int i = firstIndex; i < lastIndex + 1; i++) {
            for (int j = i; j > firstIndex; j--) {
                if (!(numbers[j] == null) && numbers[j].doubleValue() > numbers[j - 1].doubleValue()) {
                    temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }
            }
        }
    }

    void sortDesc(Number value) {
        int index = getIndex(value);
        sortDesc(index, numbers.length - 1);
    }

    void sortAsc() {
        Number temp;
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i; j > 0; j--) {
                if (!(numbers[j] == null) && numbers[j].doubleValue() < numbers[j - 1].doubleValue()) {
                    temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }
            }
        }
    }

    void sortAsc(int firstIndex, int lastIndex) {
        Number temp;
        for (int i = firstIndex; i < lastIndex + 1; i++) {
            for (int j = i; j > firstIndex; j--) {
                if (!(numbers[j] == null) && numbers[j].doubleValue() < numbers[j - 1].doubleValue()) {
                    temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }
            }
        }
    }

    void sortAsc(Number value) {
        int index = getIndex(value);
        sortAsc(index, numbers.length - 1);
    }

    Number get(int index) {
        return this.getNumbers()[index];
    }

    Number getMax() {
        MathSet ms = new MathSet(this.getNumbers());
        ms.sortDesc();
        return ms.getNumbers()[0];
    }

    Number getMin() {
        MathSet ms = new MathSet(this.getNumbers());
        ms.sortAsc();
        return ms.getNumbers()[0];
    }

    Number getAverage() {
        Number sum = 0;
        if (this.getSize() == 0) {
            return 0;
        }
        for (Number number : numbers) {
            if (number != null) {
                sum = sum.doubleValue() + number.doubleValue();
            }
        }
        return sum.doubleValue() / this.getSize();
    }

    Number getMedian() {
        MathSet ms = new MathSet(this.getNumbers());
        ms.sortAsc();
        int count = 0;
        if (numbers.length == 0) {
            return 0;
        } else if(numbers.length % 2 == 0) {
            return (ms.getNumbers()[ms.getSize() / 2].doubleValue() + ms.getNumbers()[(ms.getSize() / 2) - 1].doubleValue()) / 2;
        } else {
            return ms.getNumbers()[ms.getSize() / 2];
        }
    }

    Number[] toArray() {
        return this.getNumbers();
    }

    Number[] toArray(int firstIndex, int lastIndex) {
        int size = lastIndex - firstIndex + 1;
        int index = 0;
        Number[] result = new Number[size];
        for (int i = firstIndex; i < lastIndex + 1; i++) {
            result[index] = this.getNumbers()[i];
            index++;
        }
        return result;
    }

    MathSet cut(int firstIndex, int lastIndex) {
        Number[] array = this.toArray(firstIndex, lastIndex);
        MathSet ms = new MathSet();
        ms.setNumbers(array);
        return ms;
    }

    void clear() {
        for (int i = 0; i < getNumbers().length; i++) {
            numbers[i] = null;
        }
    }

    void clear(Number[] numbers) {
        int index;
        for (Number num : numbers) {
            index = getIndex(num);
            this.numbers[index] = null;
            for (int i = index; i < this.numbers.length; i++) {
                if (i == this.numbers.length - 1) {
                    this.numbers[i] = null;
                } else {
                    this.numbers[i] = this.numbers[i + 1];
                }
            }
        }
    }

    private int getIndex(Number number) {
        int index = 0;
        if (isInSet(number, this.getNumbers())) {
            while (this.getNumbers()[index] != number) {
                index++;
            }
        }
        return index;
    }

    private void increaseSet() {
        this.size = size * 3 / 2 + 1;
        Number[] temp = new Number[size];
        for (int i = 0; i < this.numbers.length; i++) {
            temp[i] = this.numbers[i];
        }
        this.numbers = temp;
    }

    private Number[] joinSets(MathSet... numbers) {
        int size = 0;
        int index = 0;
        for (MathSet num : numbers) {
            size += num.getNumbers().length;
        }
        Number[] allNumbers = new Number[size];
        for (MathSet num : numbers) {
            for (Number n : num.getNumbers()) {
                allNumbers[index] = n;
                index++;
            }
        }
        return getUniqueValues(allNumbers);
    }

    private Number[] joinArrays(Number[]... numbers) {
        int size = 0;
        int index = 0;
        for (Number[] num : numbers) {
            size += num.length;
        }
        Number[] allNumbers = new Number[size];
        for (Number[] num : numbers) {
            for (Number n : num) {
                allNumbers[index] = n;
                index++;
            }
        }
        return allNumbers;
    }

    private Number[] intersect(MathSet msShort, MathSet msLong) {
        int position = 0;
        for (int i = 0; i < msShort.getNumbers().length; i++) {
            if (isInSet(msShort.getNumbers()[i], msLong.getNumbers())) {
                position++;
            }
        }
        Number[] result = new Number[position];
        position = 0;
        for (int i = 0; i < msShort.getNumbers().length; i++) {
            if (isInSet(msShort.getNumbers()[i], msLong.getNumbers())) {
                result[position] = msShort.getNumbers()[i];
                position++;
            }
        }
        return result;
    }

    private Number[] getUniqueValues(Number[] numbers) {
        Number[] result = new Number[numbers.length];
        int position = 0;
        boolean inSet;
        for (int i = 0; i < numbers.length; i++) {
            inSet = false;
            for (int j = 0; j < i; j++) {
                inSet = isInSet(numbers[i], result);
            }
            if (!(numbers[i] == null) && inSet == false) {
                result[position] = numbers[i];
                position++;
            }
        }
        return result;
    }
}
