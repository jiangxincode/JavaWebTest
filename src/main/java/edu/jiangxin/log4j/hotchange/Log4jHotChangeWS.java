package edu.jiangxin.log4j.hotchange;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 修改此类，需要同时修改cnblogs中的对应文章
 * @author jiangxin
 *
 */
@Path("/conf")
@Component("log4jHotChangeWS")
public class Log4jHotChangeWS {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/log/package/{package}/{level}")
	public Response index(@PathParam("package") String p, @PathParam("level") String l) {
		Level level = Level.toLevel(l);
		Logger logger = LogManager.getLogger(p);
		logger.setLevel(level);
		return Response.ok().build();
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/log/root/{level}")
	public Response index(@PathParam("level") String l) {
		Level level = Level.toLevel(l);
		LogManager.getRootLogger().setLevel(level);
		return Response.ok().build();
	}

}