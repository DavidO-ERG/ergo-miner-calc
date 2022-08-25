<div align="center">

# ergo-miner-calc

## A calculator for the Ergo Blockchain Miners

[Getting Started](#getting-started) ⛏
[Installation](#installation) ⛏
[Guide](#guide) ⛏
[Video Guide](#video-guide) ⛏
[Next Steps](#next-steps) ⛏
[Contributing](#contributing)   ⛏
[Links](#links)⛏
[Special Notes](#special-notes)

<img src="https://img.shields.io/badge/version-0.1.0--BETA-blue">
<img src="https://img.shields.io/badge/PT-flag.svg?color=555555&style=flat-square&logo=data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTkuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgdmlld0JveD0iMCAwIDUxMiA1MTIiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDUxMiA1MTI7IiB4bWw6c3BhY2U9InByZXNlcnZlIj4KPHJlY3QgeT0iODUuMzM3IiBzdHlsZT0iZmlsbDojRDgwMDI3OyIgd2lkdGg9IjUxMiIgaGVpZ2h0PSIzNDEuMzI2Ii8+Cjxwb2x5Z29uIHN0eWxlPSJmaWxsOiM2REE1NDQ7IiBwb2ludHM9IjE5Ni42NDEsODUuMzM3IDE5Ni42NDEsMjYxLjU2NSAxOTYuNjQxLDQyNi42NjMgMCw0MjYuNjYzIDAsODUuMzM3ICIvPgo8Y2lyY2xlIHN0eWxlPSJmaWxsOiNGRkRBNDQ7IiBjeD0iMTk2LjY0MSIgY3k9IjI1NiIgcj0iNjQiLz4KPHBhdGggc3R5bGU9ImZpbGw6I0Q4MDAyNzsiIGQ9Ik0xNjAuNjM4LDIyNHY0MC4wMDFjMCwxOS44ODIsMTYuMTE4LDM2LDM2LDM2czM2LTE2LjExOCwzNi0zNlYyMjRIMTYwLjYzOHoiLz4KPHBhdGggc3R5bGU9ImZpbGw6I0YwRjBGMDsiIGQ9Ik0xOTYuNjM4LDI3NmMtNi42MTcsMC0xMi01LjM4My0xMi0xMnYtMTZoMjQuMDAxdjE2QzIwOC42MzgsMjcwLjYxNiwyMDMuMjU0LDI3NiwxOTYuNjM4LDI3NnoiLz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPC9zdmc+Cg==">
<a href=https://ergonaut.space/en/Ergo/manifesto> <img src=https://img.shields.io/badge/READ-ERGO%20MANIFESTO-blue></a>


</div>
---

---
## Getting Started
Welcome Ergonaut!
This is a simple calculator to help miners evaluate the Mining Farm and Network Status of Ergo Blockchain.

You just need to provide your "`hashrate`", "`wattage per hour`", "`price of electricity(€ KW/h)`" and the "`hours`" you want/have been mining.

From Miners, to Miners! 
Happy Mining!

---

---
## Installation
You can download the jar file then open a Powershell/Terminal session 
and run the file as follows: `java -jar path_to_jar/ergo-miner-calc.jar`

(tested on Windows)

---

---
## Guide 
The application first connect to the API "TokenJay.App" and collect the `Ergo/SigUSD Price`.

Then establish other connection with "WhatToMine.com" and collect the `Block Time`, `Block Reward`" and `Network Hashrate`.

You just need to provide your `hashrate`, `wattage per hour`, `price of electricity(€ KW/h)` and the `hours` you want/have been mining.

If you have access to Internet, the API will fill the rest with the required fields, otherwise you'll have to enter manually.

At the end, the results will be output to the same folder as the jar file. Check the output files `Status_Miner-Farm.json`, `Status_API-Price` and `Status_API-Network.json`.

---

---
## Video Guide

- Check file `0.1.0-BETA.mp4`

---

---
## Next Steps

- Release a GUI application
- Miner Reports
- Farm Stats
- and more if possible 😊...

---

---
## Contributing
Do you wish to contribute? First, thank very much for your time 😇. Please feel free to send any improvements you want. 
This is a small open-source project to learn and grow this awesome community so thank once again! 

---

---
## Links

- [ErgoPlatform](https://ergoplatform.org/en/discover/)
- [Ergo Youtube Channel](https://www.youtube.com/c/ErgoPlatform)
- [Ergonaut.Space](https://ergonaut.space/)

---

---
## Special Notes
- This program was possible thanks to the API Services of `TokenJay.App` and `WhatToMine.com`
- This program does not send any information to anywhere online.
- This program only stores the files mentioned above in a local folder.
- The output currency is equal to Dollars ($) if Internet is available, otherwise, the currency is equal to the inserted currency (€/$).
