<div align="center">

# ergo-miner-calc

## A community calculator for the Ergo Blockchain Miners

[Getting Started](#getting-started) ⛏
[Installation](#installation) ⛏
[Guide](#guide) ⛏
[Video Guide](#video-guide) ⛏
[Next Steps](#next-steps) ⛏
[Contributing](#contributing)   ⛏
[Links](#links)⛏
[Special Notes](#special-notes)

<img src="https://img.shields.io/badge/version-0.2.3-blue">
<img src="https://img.shields.io/badge/PT-flag.svg?color=555555&style=flat-square&logo=data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTkuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgdmlld0JveD0iMCAwIDUxMiA1MTIiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDUxMiA1MTI7IiB4bWw6c3BhY2U9InByZXNlcnZlIj4KPHJlY3QgeT0iODUuMzM3IiBzdHlsZT0iZmlsbDojRDgwMDI3OyIgd2lkdGg9IjUxMiIgaGVpZ2h0PSIzNDEuMzI2Ii8+Cjxwb2x5Z29uIHN0eWxlPSJmaWxsOiM2REE1NDQ7IiBwb2ludHM9IjE5Ni42NDEsODUuMzM3IDE5Ni42NDEsMjYxLjU2NSAxOTYuNjQxLDQyNi42NjMgMCw0MjYuNjYzIDAsODUuMzM3ICIvPgo8Y2lyY2xlIHN0eWxlPSJmaWxsOiNGRkRBNDQ7IiBjeD0iMTk2LjY0MSIgY3k9IjI1NiIgcj0iNjQiLz4KPHBhdGggc3R5bGU9ImZpbGw6I0Q4MDAyNzsiIGQ9Ik0xNjAuNjM4LDIyNHY0MC4wMDFjMCwxOS44ODIsMTYuMTE4LDM2LDM2LDM2czM2LTE2LjExOCwzNi0zNlYyMjRIMTYwLjYzOHoiLz4KPHBhdGggc3R5bGU9ImZpbGw6I0YwRjBGMDsiIGQ9Ik0xOTYuNjM4LDI3NmMtNi42MTcsMC0xMi01LjM4My0xMi0xMnYtMTZoMjQuMDAxdjE2QzIwOC42MzgsMjcwLjYxNiwyMDMuMjU0LDI3NiwxOTYuNjM4LDI3NnoiLz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPC9zdmc+Cg==">
<a href=https://ergonaut.space/en/Ergo/manifesto> <img src=https://img.shields.io/badge/READ-ERGO%20MANIFESTO-blue></a>

![image](https://user-images.githubusercontent.com/21132833/189499396-d7d8074a-b01d-4726-abad-b12c066ce870.png)

</div>

---

---
## Getting Started

#### Welcome Ergonaut!
This is a simple community calculator to help miners evaluate approximately the Mining Farm and Network Status of the Ergo Blockchain.

You just need to provide your `Hashrate` and your `Watts/h`!

From Miners, to Miners! 

Happy Mining!

---

---
## Installation

> This WebApp requires Java JDK

#### Windows 
1. Install [Oracle Java](https://www.oracle.com/java/technologies/downloads/)
2. Download the latest [release](https://github.com/DavidO-ERG/ergo-miner-calc/releases)
3. Extract the downloaded file and go to the folder `\bin`
4. Run `ergo-miner-calc.bat`
5. Open your browser and go to `localhost:9000`
6. Calculate your rewards!


#### Linux
1. Install [Oracle Java](https://www.oracle.com/java/technologies/downloads/)
    - Alternatively in an Debian based system, open Terminal and run `sudo apt install default-jre`
2. Download the latest [release](https://github.com/DavidO-ERG/ergo-miner-calc/releases)
3. Extract the downloaded file, go the root folder and apply `chmod +x /bin/ergo-miner-calc`
4. Run `ergo-miner-calc`
5. Open your browser and go to `localhost:9000`
6. Calculate your rewards!

---

---
## Guide 
- The application first connect to the API `CoinGecko` and collects the `Ergo Price in Euros (€)`.
- The other connection is with `WhatToMine` and collects the `Block Time`, `Block Reward` and `Network Hashrate`.
- You just need to provide your `Hashrate` and your `Watts/h`.
- If you have access to Internet, the API will fill the rest with the required fields, 
otherwise you'll have to enter all fields manually.
- At the end, the files will be stored inside `MinerStats` folder.
- Check the output files: `ErgoPrice.json` and `WhatToMine.json`. The file `MinerStats.json` is still under work.

---

---
## Video Guide

- Check file `0.2.0.mp4`

---

---
## Next Steps

- Continue working on MinerStats file
- Add "Miner Reports"
- Add connection to Ergo Node
- and more if possible 😊...

---

---
## Contributing
Do you wish to contribute? First, thank very much for your time 😇. Please feel free to send any improvements you want.
This is a small open-source project to learn and grow this awesome community so thank once more! 

---

---
## Links

- [Discover Ergo](https://ergoplatform.org/en/discover/)
- [Ergo Youtube Channel](https://www.youtube.com/c/ErgoPlatform)
- [Ergonaut.Space](https://ergonaut.space/)

---

---
## Special Notes
- This program was possible thanks to the API Services of `CoinGecko` and `WhatToMine`.
- This program does not send any information to anywhere online.
- This program only stores the files mentioned above in local folders.
- The output currency is in Euros (€) if Internet is available, otherwise the currency is equal to the inserted currency (€ or $).
