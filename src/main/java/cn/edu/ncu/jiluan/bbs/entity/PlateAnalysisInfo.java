package cn.edu.ncu.jiluan.bbs.entity;

public class PlateAnalysisInfo extends PlateEntity{
    private long postCount;
    private long replyCount;

    public PlateAnalysisInfo(PlateEntity plateEntity){
        this.plateId = plateEntity.plateId;
        this.plateName = plateEntity.plateName;
    }

    public long getPostCount() {
        return postCount;
    }

    public void setPostCount(long postCount) {
        this.postCount = postCount;
    }

    public long getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(long replyCount) {
        this.replyCount = replyCount;
    }
}
