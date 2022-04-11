package kr.imcf.mybatis.account;

import kr.imcf.mybatis.domain.TblAccount;
import kr.imcf.mybatis.mapper.TblAccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountService {
    // 로깅에 사용하는 라이브러리 (@Slf4j 필요)
    private static final Logger logger = LogManager.getLogger(AccountService.class);

    @Autowired
    private TblAccountMapper tblAccountMapper;

    // 모든 사용자 정보를 리턴하는 서비스입니다
    public AccountResponse getAccountAll(){
        logger.trace("요청이 들어왔습니다");

        AccountResponse response = new AccountResponse();
        List<TblAccount> tblAccounts = tblAccountMapper.selectAll();

        for(TblAccount one : tblAccounts){
            response.addAccountInfo(new AccountResponse.AccountInfo(one.getId(), one.getCreatedDate(), one.getModifiedDate(), one.getAccessToken(), one.getEmail(), one.getIsAuth(),
                    one.getPassword(), one.getPlatformType(), one.getProfileImage(), one.getRefreshToken(), one.getRole(), one.getUserName(), one.getRecvMail()));
        }

        return response;
    }
}
