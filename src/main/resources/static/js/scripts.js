var asseXValue = [], asseY1Value=[], asseY2Value=[];

async function getDataAlerty(){
    const apiUrl="http://localhost:8080/main"
    const response = await fetch(apiUrl)
    const barChartData= await response.json()

    console.log(barChartData)

    const date = barChartData.data.map((x) => x.date);
    const temp= barChartData.data.map((x) => x.temp);
    const humi = barChartData.data.map((x) => x.humi);

    for(var i=0;i<date.length;i++){
        var data=((date[i].substring(0,10))+" "+(date[i].substring(11,19)))

        asseXValue.push(data)
    }

    temp.forEach(element=>asseY1Value.push(element))
    humi.forEach(element=>asseY2Value.push(element))

    console.log(asseXValue,asseY1Value,asseY2Value);
}

async function startChart(){

    await getDataAlerty();

    let chartContainer = new Chart(
        document.getElementById("chartContainer").getContext("2d"),
        config
    )
}

startChart()

const data = {
    labels: asseXValue,
    datasets: [
        {
            label: "Temp",
            data: asseY1Value,
            backgroundColor: "rgb(255,255,255)",
            yAxisID: "yTemp",
            borderColor: "rgb(255,0,0)"
        },
        {
            label: "Humi",
            data: asseY2Value,
            backgroundColor: "rgb(0,0,255)",
            yAxisID: "yHumi",
            type: "bar"
        }
    ]
};
// config
const config = {
    type: "line",
    data,
    options: {
        tooltips:{

          mode:"index"
        },
        scales: {
            yTemp: {
                beginAtZero: true,
                type: "linear",
                position: "left",
                ticks: {
                    min: -10,
                    max: 35,
                    color: "#26d840",
                    font: { size: 20, family: "VT323", weight: 600 }
                }
            },
            yHumi: {
                beginAtZero: true,
                type: "linear",
                position: "right",
                ticks: {
                    min: 0,
                    max: 100,
                    color: "#26d840",
                    font: { size: 20, family: "VT323" }
                }
            },
            x: {
                ticks: { color: "#26d840", font: { size: 20, family: "VT323" } }
            }
        },
        plugins: {
            legend: {
                display: true,
                labels: { color: "#26d840", font: { size: 20, family: "VT323" } }
            }
        }
    }
};

// render init block

function colorChanger(){
    let item = document.getElementById("tableAlert");

    if(parseInt(item.textContent)<10 || parseInt(item.textContent)>35){
        item.style.color="rgb(255,0,0)";
    }
}

function colorChangerHumi(){
    let item = document.getElementById("humiValue");
    if(parseInt(item.textContent)<20 || parseInt(item.textContent)>99){
        item.style.color="rgb(255,0,0)";
    }
}

window.onresize= function(){
    location.reload()
}

