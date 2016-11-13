package support.support;

import org.apache.commons.lang.time.DateFormatUtils;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.util.Date;


public class DateTimeSerializer extends JsonSerializer<Date> {
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		jgen.writeString(DateFormatUtils.format(value, DATE_FORMAT));
	}

}
