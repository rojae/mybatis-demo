package kr.imcf.mybatis.mapper;

import java.util.List;
import kr.imcf.mybatis.domain.TblAccount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TblAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_account
     *
     * @mbg.generated Mon Apr 11 22:51:46 KST 2022
     */
    int insert(TblAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_account
     *
     * @mbg.generated Mon Apr 11 22:51:46 KST 2022
     */
    List<TblAccount> selectAll();
}