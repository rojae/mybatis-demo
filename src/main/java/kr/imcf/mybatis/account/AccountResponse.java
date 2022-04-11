package kr.imcf.mybatis.account;


import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Account 리스트 정보를 담는 클래스입니다.
public class AccountResponse {
    public AccountResponse(){}

    public AccountResponse(List<AccountInfo> accountInfoList) {
        this.accountInfoList = accountInfoList;
    }

    private List<AccountInfo> accountInfoList;

    public void addAccountInfo(AccountInfo info){
        if(this.accountInfoList == null)
            accountInfoList = new ArrayList<>();
        this.accountInfoList.add(info);
    }

    public List<AccountInfo> getAccountInfoList() {
        return accountInfoList;
    }

    // Inner static class
    static class AccountInfo {
        public AccountInfo(){}

        public AccountInfo(Long id, Date createdDate, Date modifiedDate, String accessToken, String email, Byte isAuth, String password, String platformType, String profileImage, String refreshToken, String role, String userName, Byte recvMail) {
            this.id = id;
            this.createdDate = createdDate;
            this.modifiedDate = modifiedDate;
            this.accessToken = accessToken;
            this.email = email;
            this.isAuth = isAuth;
            this.password = password;
            this.platformType = platformType;
            this.profileImage = profileImage;
            this.refreshToken = refreshToken;
            this.role = role;
            this.userName = userName;
            this.recvMail = recvMail;
        }

        private Long id;
        private Date createdDate;
        private Date modifiedDate;
        private String accessToken;
        private String email;
        private Byte isAuth;
        private String password;
        private String platformType;
        private String profileImage;
        private String refreshToken;
        private String role;
        private String userName;
        private Byte recvMail;

        public Long getId() {
            return id;
        }

        public Date getCreatedDate() {
            return createdDate;
        }

        public Date getModifiedDate() {
            return modifiedDate;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public String getEmail() {
            return email;
        }

        public Byte getIsAuth() {
            return isAuth;
        }

        public String getPassword() {
            return password;
        }

        public String getPlatformType() {
            return platformType;
        }

        public String getProfileImage() {
            return profileImage;
        }

        public String getRefreshToken() {
            return refreshToken;
        }

        public String getRole() {
            return role;
        }

        public String getUserName() {
            return userName;
        }

        public Byte getRecvMail() {
            return recvMail;
        }
    }
}
