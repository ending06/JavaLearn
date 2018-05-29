package com.qunar.test.usercard;

import com.qunar.pay.trade.api.card.dto.query.CardQueryParam;
import com.qunar.pay.trade.api.card.dto.query.CardQueryResult;
import com.qunar.pay.trade.api.card.model.UserCardInfo;
import com.qunar.pay.trade.api.card.service.usercard.UserCardQueryFacade;
import com.qunar.pay.trade.commons.model.QResponse;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 18/5/29<p>
// -------------------------------------------------------
public class UserCardQueryFacadeTest {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml"});
        context.start();

        CardQueryParam cardQueryParam = CardQueryParam.newParam(CardQueryParam.QueryKey.USER_ID, "1444477214");

        UserCardQueryFacade userCardQueryFacade = (UserCardQueryFacade) context.getBean("userCardQueryFacade"); // 获取远程服务代理
        QResponse<CardQueryResult<UserCardInfo>> response = userCardQueryFacade.queryUserCard(cardQueryParam);
    }
}
