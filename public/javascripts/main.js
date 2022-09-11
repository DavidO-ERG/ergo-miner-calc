// To calculate dailyBlockRewards()
const minutesPerDay = 1440;

// For the Loading Screen
function timeOutLoadingPage() {
  return setTimeout(showPage, 3000);
}
function showPage() {
  document.getElementById("loader").style.display = "none";
  document.getElementById("root2").style.display = "block";
}

// Show Results to User
function finalResults() {
    document.getElementById("currentPriceBox").innerHTML = document.getElementById("currentPrice").value + " €";
    document.getElementById("dailyRevenue").innerHTML = dailyRevenue().toFixed(2) + " €";
    document.getElementById("dailyCost").innerHTML = dailyCost().toFixed(2) + " €";
    document.getElementById("dailyDiff").innerHTML = (dailyRevenue() - dailyCost()).toFixed(2) + " €";
//    saveResults();
}

function resetAll() {
    document.getElementById("currentPriceBox").innerHTML = "";
    document.getElementById("dailyRevenue").innerHTML = "";
    document.getElementById("dailyCost").innerHTML = "";
    document.getElementById("dailyDiff").innerHTML = "";

    document.getElementById("hashrate").setAttribute("value", "");
    document.getElementById("wattsHour").setAttribute("value", "");
    document.getElementById("currentPrice").setAttribute("value", "");
    document.getElementById("priceKwHour").setAttribute("value", "");
    document.getElementById("hoursMined").setAttribute("value", "");
    document.getElementById("networkHashrate").setAttribute("value", "");
    document.getElementById("blockRewards").setAttribute("value", "");
    document.getElementById("blockTime").setAttribute("value", "");
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