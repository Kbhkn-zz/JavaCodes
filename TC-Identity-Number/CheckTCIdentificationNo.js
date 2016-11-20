function isTCNoValid(tcKimlikNo) {
    tcKimlikNo = tcKimlikNo.toString();

    if (!/^[1-9]{1}[0-9]{10}$/.test(tcKimlikNo))
        return false;

    var totalOddIndexs = 0, totalEvenIndexs = 0, total = 0;
    var digit10 = tcKimlikNo.substr(9, 1);
    var digit11 = tcKimlikNo.substr(10, 1);

    for (var i = 0; i < 9; i++) {
        var value = Number(tcKimlikNo.substr(i, 1));

        if (i % 2 === 0) {
            totalOddIndexs += value;
        } else {
            totalEvenIndexs += value;
        }

        total += value;
    }

    var newDigit10 = ((totalOddIndexs * 7) - totalEvenIndexs) % 10;

    return (digit10 == newDigit10) && (digit11 == (total + newDigit10) % 10);
}