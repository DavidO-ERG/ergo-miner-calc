const minutesPerDay = 1440;

function finalResults() {
    document.getElementById("currentPriceBox").innerHTML = document.getElementById("currentPrice").value + " €";
    document.getElementById("dailyRevenue").innerHTML = dailyRevenue().toFixed(2) + " €";
    document.getElementById("dailyCost").innerHTML = dailyCost().toFixed(2) + " €";
    document.getElementById("dailyDiff").innerHTML = (dailyRevenue() - dailyCost()).toFixed(2) + " €";
//    saveResults();
}

function resetAll() {
    document.getElementById("currentPriceBox").innerHTML = "0.00 €";
    document.getElementById("dailyRevenue").innerHTML = "0.00 €";
    document.getElementById("dailyCost").innerHTML = "0.00 €";
    document.getElementById("dailyDiff").innerHTML = "0.00 €";
}

function kwPerHour() {
    var wattsHour = document.getElementById("wattsHour").value;
    var hoursMined = document.getElementById("hoursMined").value;
    return (wattsHour / 1000) * hoursMined;
}

function dailyBlockRewards() {
    var blockRewards = document.getElementById("blockRewards").value;
    var blockTime = document.getElementById("blockTime").value / 60.0;
    return blockRewards * (minutesPerDay / blockTime);
}

function dailyBlockRewardsInValue() {
    var currentPrice = document.getElementById("currentPrice").value;
    return dailyBlockRewards() * currentPrice;
}

function dailyCost() {
    var priceKwHour = document.getElementById("priceKwHour").value;
    return kwPerHour() * priceKwHour;
}

function dailyRevenue() {
    var networkHashrate = (document.getElementById("networkHashrate").value * 1000000.0);
    var hashrate = document.getElementById("hashrate").value;
    return (dailyBlockRewardsInValue() / networkHashrate) * hashrate;
}

function minerNetworkShare() {
    var networkHashrate = (document.getElementById("networkHashrate").value * 1000000.0);
    var hashrate = document.getElementById("hashrate").value;
    return hashrate / networkHashrate;
}

function dailyRevenueErg() {
    return dailyBlockRewards() * minerNetworkShare();
}