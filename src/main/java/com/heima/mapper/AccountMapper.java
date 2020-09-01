package com.heima.mapper;

import com.heima.entity.Account;
import com.heima.entity.AccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    Account getAccountById(@Param("accountId") int accountId );

    long transferReduce(@Param("sourceId")int sourceId,@Param("money") int money);
    long transferAdd(@Param("targetId")int targetId,@Param("money")int money);
}