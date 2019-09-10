package jialei.com.stc

class StcScanResponse (
    var repoId: String = "",
    var success: String = ""
)

class StcQueryResponse(
    var scanStatus: String = "",
    var success: String = "",
    var result: ScanResult?=null
)

class ScanResult(
    var whiteScanStatus:ScanStatusItem?=null,
    var blackScanStatus:ScanStatusItem?=null
)

class ScanStatusItem(
    var display: String = "",
    var isBlock: String = "",
    var status: String = "",
    var securityCountersigner: String = "",
    var qualityDirector: String = ""
)