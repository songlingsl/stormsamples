package my;


import java.io.Serializable;

/**
 * @author HuangLin
 * @date 2018/9/22 15:32
 */
public class GeneralMessageSendVO implements Serializable {
    //(value="用户ID")
    private int ownerId = 0;

    //(value="主键ID")
    private long msgContentId = 0;

    //(value="信息标识")
    private long msgId = 0;

    //(value="相同信息总长数")
    private int pkTotal = 1;

    //(value="相同信息序号")
    private int pkNumber = 1;

    //(value="是否要求返回状态确认报告")
    private int registeredDelivery = 0;

    //(value="信息级别")
    private int msgLevel = 1;

    //(value="业务类型", required = true)
    private String prdtNo = "";

    //(value="计费用户类型")
    private int feeUserType = 2;

    //(value="被计费用户号码")
    private String feeTerminalId = "";

    //(value="GSM协议类型")
    private int tppId = 0;

    //(value="GSM协议类型")
    private int tpuDhi = 0;

    //(value="信息格式")
    private int msgFmt = 8;

    //(value="信息内容来源", required = true)
    private String msgSrc = "";

    //(value="资费类别")
    private String feeType = "02";

    //(value="资费代码")
    private String feeCode = "0";

    //(value="存活有效期")
    private String valIdTime = null;

    //(value="定时发送时间")
    private String atTime = null;

    //(value="源号码")
    private String srcId = "";

    //(value="接收信息用户数量")
    private int destUsrTl = 0;

    //(value="接收短信的MSISDN号码", required = true)
    private String phoneNumbers = "";

    //(value="信息长度")
    private int msgLength = 0;

    //(value="信息内容", required = true)
    private String content = "";

    //(value="保留")
    private String reserve = "";

    //(value="接收短信的用户的号码类型")
    private int destTerminalType;

    //(value="点播业务")
    private String linkId;

    //(value="响应信息标识")
    private long msgIdRes;

    //(value="结果")
    private int result = -1;

    //(value="平台扩展号")
    private String extraNo = "";

    //(value="外键id")
    private int msgConnectId = 0;

    //(value="短信类型")
    private String msgType = "";

    //(value="创建时间")
    private String createTime = null;

    //(value="发送时间")
    private String sendTime = null;

    //(value="短信账号")
    private String acctNo = "";

    //(value="通道ID")
    private int channelId = 0;

    //(value="接口类型")
    private String interfaceType;

    //(value="接口IP")
    private String interfaceIP;

    //(value="接口端口")
    private int interfacePort;

    //(value="接口URL")
    private String interfaceUrl;

    //(value="接口用户名")
    private String interfaceUser;

    //(value="接口密码")
    private String interfacePassword;

    //(value="设备IP")
    private String deviceIp;

    //(value="设备端口")
    private int devicePort;

    //(value="storm过滤类型")
    private int filterType = 0;

    //(value="接入socket标识")
    private String socketName;

    //(value="接入IP")
    private String inputIp;

    //(value="接入端口")
    private int inputPort;

    //(value="是否检查内容包含非法关键字")
    private int checkContent;

    //(value="任务名称")
    private String taskName;

    //(value="号码总数量")
    private int countNumber;

    //(value="手机号码数量")
    private int mobileNumber;

    //(value="小灵通或座机号码数")
    private int telephoneNumber;

    //(value="网关类型")
    private String carrieroperator;

    //(value="通道socket名")
    private String channelSocketName;

    //(value="客户提交扩展号")
    private String clientSubmitExtraNo;

    //((value="是否平台发出短信 1是  0否")
    private int isPlatformMsg = 0;

    //((value="租户ID")
    private int tenancyId = 0;

    //@ApiModelProperty(value="尝试发送次数")
    private int retryTimes = 0;

    //ApiModelProperty(value="是否重发 1是 0否")
    private int isResend = 0;

    //是否为通道组(0代表通道  1代表通道组)
    private int isChannelGroup = 0;

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public long getMsgContentId() {
        return msgContentId;
    }

    public void setMsgContentId(long msgContentId) {
        this.msgContentId = msgContentId;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    public int getPkTotal() {
        return pkTotal;
    }

    public void setPkTotal(int pkTotal) {
        this.pkTotal = pkTotal;
    }

    public int getPkNumber() {
        return pkNumber;
    }

    public void setPkNumber(int pkNumber) {
        this.pkNumber = pkNumber;
    }

    public int getRegisteredDelivery() {
        return registeredDelivery;
    }

    public void setRegisteredDelivery(int registeredDelivery) {
        this.registeredDelivery = registeredDelivery;
    }

    public int getMsgLevel() {
        return msgLevel;
    }

    public void setMsgLevel(int msgLevel) {
        this.msgLevel = msgLevel;
    }

    public String getPrdtNo() {
        return prdtNo;
    }

    public void setPrdtNo(String prdtNo) {
        this.prdtNo = prdtNo;
    }

    public int getFeeUserType() {
        return feeUserType;
    }

    public void setFeeUserType(int feeUserType) {
        this.feeUserType = feeUserType;
    }

    public String getFeeTerminalId() {
        return feeTerminalId;
    }

    public void setFeeTerminalId(String feeTerminalId) {
        this.feeTerminalId = feeTerminalId;
    }

    public int getTppId() {
        return tppId;
    }

    public void setTppId(int tppId) {
        this.tppId = tppId;
    }

    public int getTpuDhi() {
        return tpuDhi;
    }

    public void setTpuDhi(int tpuDhi) {
        this.tpuDhi = tpuDhi;
    }

    public int getMsgFmt() {
        return msgFmt;
    }

    public void setMsgFmt(int msgFmt) {
        this.msgFmt = msgFmt;
    }

    public String getMsgSrc() {
        return msgSrc;
    }

    public void setMsgSrc(String msgSrc) {
        this.msgSrc = msgSrc;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public String getValIdTime() {
        return valIdTime;
    }

    public void setValIdTime(String valIdTime) {
        this.valIdTime = valIdTime;
    }

    public String getAtTime() {
        return atTime;
    }

    public void setAtTime(String atTime) {
        this.atTime = atTime;
    }

    public String getSrcId() {
        return srcId;
    }

    public void setSrcId(String srcId) {
        this.srcId = srcId;
    }

    public int getDestUsrTl() {
        return destUsrTl;
    }

    public void setDestUsrTl(int destUsrTl) {
        this.destUsrTl = destUsrTl;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public int getMsgLength() {
        return msgLength;
    }

    public void setMsgLength(int msgLength) {
        this.msgLength = msgLength;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public int getDestTerminalType() {
        return destTerminalType;
    }

    public void setDestTerminalType(int destTerminalType) {
        this.destTerminalType = destTerminalType;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public long getMsgIdRes() {
        return msgIdRes;
    }

    public void setMsgIdRes(long msgIdRes) {
        this.msgIdRes = msgIdRes;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getExtraNo() {
        return extraNo;
    }

    public void setExtraNo(String extraNo) {
        this.extraNo = extraNo;
    }

    public int getMsgConnectId() {
        return msgConnectId;
    }

    public void setMsgConnectId(int msgConnectId) {
        this.msgConnectId = msgConnectId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getInterfaceIP() {
        return interfaceIP;
    }

    public void setInterfaceIP(String interfaceIP) {
        this.interfaceIP = interfaceIP;
    }

    public int getInterfacePort() {
        return interfacePort;
    }

    public void setInterfacePort(int interfacePort) {
        this.interfacePort = interfacePort;
    }

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }

    public String getInterfaceUser() {
        return interfaceUser;
    }

    public void setInterfaceUser(String interfaceUser) {
        this.interfaceUser = interfaceUser;
    }

    public String getInterfacePassword() {
        return interfacePassword;
    }

    public void setInterfacePassword(String interfacePassword) {
        this.interfacePassword = interfacePassword;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    public int getDevicePort() {
        return devicePort;
    }

    public void setDevicePort(int devicePort) {
        this.devicePort = devicePort;
    }

    public int getFilterType() {
        return filterType;
    }

    public void setFilterType(int filterType) {
        this.filterType = filterType;
    }

    public String getSocketName() {
        return socketName;
    }

    public void setSocketName(String socketName) {
        this.socketName = socketName;
    }

    public String getInputIp() {
        return inputIp;
    }

    public void setInputIp(String inputIp) {
        this.inputIp = inputIp;
    }

    public int getInputPort() {
        return inputPort;
    }

    public void setInputPort(int inputPort) {
        this.inputPort = inputPort;
    }

    public int getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(int checkContent) {
        this.checkContent = checkContent;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getCountNumber() {
        return countNumber;
    }

    public void setCountNumber(int countNumber) {
        this.countNumber = countNumber;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getCarrieroperator() {
        return carrieroperator;
    }

    public void setCarrieroperator(String carrieroperator) {
        this.carrieroperator = carrieroperator;
    }

    public String getChannelSocketName() {
        return channelSocketName;
    }

    public void setChannelSocketName(String channelSocketName) {
        this.channelSocketName = channelSocketName;
    }

    public String getClientSubmitExtraNo() {
        return clientSubmitExtraNo;
    }

    public void setClientSubmitExtraNo(String clientSubmitExtraNo) {
        this.clientSubmitExtraNo = clientSubmitExtraNo;
    }

    public int getIsPlatformMsg() {
        return isPlatformMsg;
    }

    public void setIsPlatformMsg(int isPlatformMsg) {
        this.isPlatformMsg = isPlatformMsg;
    }

    public int getTenancyId() {
        return tenancyId;
    }

    public void setTenancyId(int tenancyId) {
        this.tenancyId = tenancyId;
    }

    public int getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
    }

    public int getIsResend() {
        return isResend;
    }

    public void setIsResend(int isResend) {
        this.isResend = isResend;
    }

    public int getIsChannelGroup() {
        return isChannelGroup;
    }

    public void setIsChannelGroup(int isChannelGroup) {
        this.isChannelGroup = isChannelGroup;
    }

    public static GeneralMessageSendVO copyNewInstance(GeneralMessageSendVO generalMessageSendVO) {
        return new GeneralMessageSendVO(generalMessageSendVO.getOwnerId(), generalMessageSendVO.getMsgContentId(), generalMessageSendVO.getMsgId(), generalMessageSendVO.getPkTotal(),
                generalMessageSendVO.getPkNumber(), generalMessageSendVO.getRegisteredDelivery(), generalMessageSendVO.getMsgLevel(), generalMessageSendVO.getPrdtNo(),
                generalMessageSendVO.getFeeUserType(), generalMessageSendVO.getFeeTerminalId(), generalMessageSendVO.getTppId(), generalMessageSendVO.getTpuDhi(),
                generalMessageSendVO.getMsgFmt(), generalMessageSendVO.getMsgSrc(), generalMessageSendVO.getFeeType(), generalMessageSendVO.getFeeCode(),
                generalMessageSendVO.getValIdTime(), generalMessageSendVO.getAtTime(), generalMessageSendVO.getSrcId(), generalMessageSendVO.getDestUsrTl(),
                generalMessageSendVO.getPhoneNumbers(), generalMessageSendVO.getMsgLength(), generalMessageSendVO.getContent(), generalMessageSendVO.getReserve(),
                generalMessageSendVO.getDestTerminalType(), generalMessageSendVO.getLinkId(), generalMessageSendVO.getMsgIdRes(), generalMessageSendVO.getResult(),
                generalMessageSendVO.getExtraNo(), generalMessageSendVO.getMsgConnectId(), generalMessageSendVO.getMsgType(), generalMessageSendVO.getCreateTime(),
                generalMessageSendVO.getSendTime(), generalMessageSendVO.getAcctNo(), generalMessageSendVO.getChannelId(), generalMessageSendVO.getInterfaceType(),
                generalMessageSendVO.getInterfaceIP(), generalMessageSendVO.getInterfacePort(), generalMessageSendVO.getInterfaceUrl(), generalMessageSendVO.getInterfaceUser(),
                generalMessageSendVO.getInterfacePassword(), generalMessageSendVO.getDeviceIp(), generalMessageSendVO.getDevicePort(), generalMessageSendVO.getFilterType(),
                generalMessageSendVO.getSocketName(), generalMessageSendVO.getInputIp(), generalMessageSendVO.getInputPort(), generalMessageSendVO.getCheckContent(),
                generalMessageSendVO.getTaskName(), generalMessageSendVO.getCountNumber(), generalMessageSendVO.getMobileNumber(), generalMessageSendVO.getTelephoneNumber(),
                generalMessageSendVO.getCarrieroperator(), generalMessageSendVO.getChannelSocketName(), generalMessageSendVO.getClientSubmitExtraNo(), generalMessageSendVO.getIsPlatformMsg(),
                generalMessageSendVO.getTenancyId(), generalMessageSendVO.getRetryTimes(), generalMessageSendVO.getIsResend(), generalMessageSendVO.getIsChannelGroup());
    }

    public GeneralMessageSendVO(int ownerId, long msgContentId, long msgId, int pkTotal, int pkNumber, int registeredDelivery, int msgLevel, String prdtNo, int feeUserType,
                                String feeTerminalId, int tppId, int tpuDhi, int msgFmt, String msgSrc, String feeType, String feeCode, String valIdTime, String atTime, String srcId,
                                int destUsrTl, String phoneNumbers, int msgLength, String content, String reserve, int destTerminalType, String linkId, long msgIdRes, int result,
                                String extraNo, int msgConnectId, String msgType, String createTime, String sendTime, String acctNo, int channelId, String interfaceType,
                                String interfaceIP, int interfacePort, String interfaceUrl, String interfaceUser, String interfacePassword, String deviceIp, int devicePort,
                                int filterType, String socketName, String inputIp, int inputPort, int checkContent, String taskName, int countNumber, int mobileNumber, int telephoneNumber,
                                String carrieroperator, String channelSocketName, String clientSubmitExtraNo, int isPlatformMsg, int tenancyId, int retryTimes, int isResend, int isChannelGroup) {
        this.ownerId = ownerId;
        this.msgContentId = msgContentId;
        this.msgId = msgId;
        this.pkTotal = pkTotal;
        this.pkNumber = pkNumber;
        this.registeredDelivery = registeredDelivery;
        this.msgLevel = msgLevel;
        this.prdtNo = prdtNo;
        this.feeUserType = feeUserType;
        this.feeTerminalId = feeTerminalId;
        this.tppId = tppId;
        this.tpuDhi = tpuDhi;
        this.msgFmt = msgFmt;
        this.msgSrc = msgSrc;
        this.feeType = feeType;
        this.feeCode = feeCode;
        this.valIdTime = valIdTime;
        this.atTime = atTime;
        this.srcId = srcId;
        this.destUsrTl = destUsrTl;
        this.phoneNumbers = phoneNumbers;
        this.msgLength = msgLength;
        this.content = content;
        this.reserve = reserve;
        this.destTerminalType = destTerminalType;
        this.linkId = linkId;
        this.msgIdRes = msgIdRes;
        this.result = result;
        this.extraNo = extraNo;
        this.msgConnectId = msgConnectId;
        this.msgType = msgType;
        this.createTime = createTime;
        this.sendTime = sendTime;
        this.acctNo = acctNo;
        this.channelId = channelId;
        this.interfaceType = interfaceType;
        this.interfaceIP = interfaceIP;
        this.interfacePort = interfacePort;
        this.interfaceUrl = interfaceUrl;
        this.interfaceUser = interfaceUser;
        this.interfacePassword = interfacePassword;
        this.deviceIp = deviceIp;
        this.devicePort = devicePort;
        this.filterType = filterType;
        this.socketName = socketName;
        this.inputIp = inputIp;
        this.inputPort = inputPort;
        this.checkContent = checkContent;
        this.taskName = taskName;
        this.countNumber = countNumber;
        this.mobileNumber = mobileNumber;
        this.telephoneNumber = telephoneNumber;
        this.carrieroperator = carrieroperator;
        this.channelSocketName = channelSocketName;
        this.clientSubmitExtraNo = clientSubmitExtraNo;
        this.isPlatformMsg = isPlatformMsg;
        this.tenancyId = tenancyId;
        this.retryTimes = retryTimes;
        this.isResend = isResend;
        this.isChannelGroup = isChannelGroup;
    }

    public GeneralMessageSendVO() {}

    @Override
    public String toString() {
        return "GeneralMessageSendVO{" +
                "ownerId=" + ownerId +
                ", msgContentId=" + msgContentId +
                ", msgId=" + msgId +
                ", pkTotal=" + pkTotal +
                ", pkNumber=" + pkNumber +
                ", registeredDelivery=" + registeredDelivery +
                ", msgLevel=" + msgLevel +
                ", prdtNo='" + prdtNo + '\'' +
                ", feeUserType=" + feeUserType +
                ", feeTerminalId='" + feeTerminalId + '\'' +
                ", tppId=" + tppId +
                ", tpuDhi=" + tpuDhi +
                ", msgFmt=" + msgFmt +
                ", msgSrc='" + msgSrc + '\'' +
                ", feeType='" + feeType + '\'' +
                ", feeCode='" + feeCode + '\'' +
                ", valIdTime='" + valIdTime + '\'' +
                ", atTime='" + atTime + '\'' +
                ", srcId='" + srcId + '\'' +
                ", destUsrTl=" + destUsrTl +
                ", phoneNumbers='" + phoneNumbers + '\'' +
                ", msgLength=" + msgLength +
                ", content='" + content + '\'' +
                ", reserve='" + reserve + '\'' +
                ", destTerminalType=" + destTerminalType +
                ", linkId='" + linkId + '\'' +
                ", msgIdRes=" + msgIdRes +
                ", result=" + result +
                ", extraNo='" + extraNo + '\'' +
                ", msgConnectId=" + msgConnectId +
                ", msgType='" + msgType + '\'' +
                ", createTime='" + createTime + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", acctNo='" + acctNo + '\'' +
                ", channelId=" + channelId +
                ", interfaceType='" + interfaceType + '\'' +
                ", interfaceIP='" + interfaceIP + '\'' +
                ", interfacePort=" + interfacePort +
                ", interfaceUrl='" + interfaceUrl + '\'' +
                ", interfaceUser='" + interfaceUser + '\'' +
                ", interfacePassword='" + interfacePassword + '\'' +
                ", deviceIp='" + deviceIp + '\'' +
                ", devicePort=" + devicePort +
                ", filterType=" + filterType +
                ", socketName='" + socketName + '\'' +
                ", inputIp='" + inputIp + '\'' +
                ", inputPort=" + inputPort +
                ", checkContent=" + checkContent +
                ", taskName='" + taskName + '\'' +
                ", countNumber=" + countNumber +
                ", mobileNumber=" + mobileNumber +
                ", telephoneNumber=" + telephoneNumber +
                ", carrieroperator='" + carrieroperator + '\'' +
                ", channelSocketName='" + channelSocketName + '\'' +
                ", clientSubmitExtraNo='" + clientSubmitExtraNo + '\'' +
                ", isPlatformMsg=" + isPlatformMsg +
                ", tenancyId=" + tenancyId +
                ", retryTimes=" + retryTimes +
                ", isResend=" + isResend +
                ", isChannelGroup=" + isChannelGroup +
                '}';
    }
}

