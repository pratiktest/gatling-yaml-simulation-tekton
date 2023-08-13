var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "60",
        "ok": "2",
        "ko": "58"
    },
    "minResponseTime": {
        "total": "244",
        "ok": "312",
        "ko": "244"
    },
    "maxResponseTime": {
        "total": "395",
        "ok": "384",
        "ko": "395"
    },
    "meanResponseTime": {
        "total": "299",
        "ok": "348",
        "ko": "298"
    },
    "standardDeviation": {
        "total": "42",
        "ok": "36",
        "ko": "41"
    },
    "percentiles1": {
        "total": "287",
        "ok": "348",
        "ko": "286"
    },
    "percentiles2": {
        "total": "312",
        "ok": "366",
        "ko": "304"
    },
    "percentiles3": {
        "total": "384",
        "ok": "380",
        "ko": "378"
    },
    "percentiles4": {
        "total": "393",
        "ok": "383",
        "ko": "393"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 2,
    "percentage": 3
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t ≥ 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t ≥ 1200 ms",
    "htmlName": "t ≥ 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 58,
    "percentage": 97
},
    "meanNumberOfRequestsPerSecond": {
        "total": "10",
        "ok": "0.333",
        "ko": "9.667"
    }
},
contents: {
"req_sample-get-req-37333": {
        type: "REQUEST",
        name: "sample get req",
path: "sample get req",
pathFormatted: "req_sample-get-req-37333",
stats: {
    "name": "sample get req",
    "numberOfRequests": {
        "total": "60",
        "ok": "2",
        "ko": "58"
    },
    "minResponseTime": {
        "total": "244",
        "ok": "312",
        "ko": "244"
    },
    "maxResponseTime": {
        "total": "395",
        "ok": "384",
        "ko": "395"
    },
    "meanResponseTime": {
        "total": "299",
        "ok": "348",
        "ko": "298"
    },
    "standardDeviation": {
        "total": "42",
        "ok": "36",
        "ko": "41"
    },
    "percentiles1": {
        "total": "287",
        "ok": "348",
        "ko": "286"
    },
    "percentiles2": {
        "total": "312",
        "ok": "366",
        "ko": "304"
    },
    "percentiles3": {
        "total": "384",
        "ok": "380",
        "ko": "378"
    },
    "percentiles4": {
        "total": "393",
        "ok": "383",
        "ko": "393"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 2,
    "percentage": 3
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t ≥ 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t ≥ 1200 ms",
    "htmlName": "t ≥ 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 58,
    "percentage": 97
},
    "meanNumberOfRequestsPerSecond": {
        "total": "10",
        "ok": "0.333",
        "ko": "9.667"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
