package net.madvirus.spring4.chap11.guest;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		useJdbc();
		useJdbcTemplate();
		useJdbcTemplate2();
		useNamedJdbcTemplate();
		useSimpleInsert();
	}

	private static void useJdbcTemplate() {
		String configLocation = "classpath:applicationContext.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(
				configLocation);

		MessageDao messageDao = ctx.getBean("jdbcTemplateMessageDao",
				MessageDao.class);
		runMessageDao(messageDao);
		ctx.close();
	}

	
	private static void useJdbcTemplate2() {
		String configLocation = "classpath:applicationContext.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(
				configLocation);
		
		MessageDao messageDao = ctx.getBean("jdbcTemplateMessageDao2",
				MessageDao.class);
		runMessageDao(messageDao);
		ctx.close();
	}
	
	private static void useNamedJdbcTemplate() {
		String configLocation = "classpath:applicationContext.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(
				configLocation);

		MessageDao messageDao = ctx.getBean("namedTemlateDao", MessageDao.class);
		runMessageDao(messageDao);
		ctx.close();
	}

	private static void useJdbc() {
		String configLocation = "classpath:applicationContext.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(
				configLocation);

		MessageDao messageDao = ctx.getBean("jdbcMessageDao",
				MessageDao.class);
		runMessageDao(messageDao);
		ctx.close();
	}

	private static void useSimpleInsert() {
		String configLocation = "classpath:applicationContext.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(
				configLocation);

		MessageDao messageDao = ctx.getBean("simpleInsertMessageDao",
				MessageDao.class);
		runMessageDao(messageDao);
		ctx.close();
	}

	private static void runMessageDao(MessageDao messageDao) {
		Message message = new Message();
		message.setMessage("?????????");
		message.setCreationTime(new Date());
		message.setName("?????????");
		int id = messageDao.insert(message);
		System.out.printf("Message[%d]??? ?????????????????????.\n", id);

		int count = messageDao.counts();
		System.out.printf("?????? ??????: %d\n", count);
		List<Message> messages = messageDao.select(0, 10);
		System.out.printf("????????? ????????? ??????: %d\n", messages.size());
	}

}
