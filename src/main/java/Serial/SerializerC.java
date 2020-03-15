package Serial;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.govoronok.bstu.entity.OrderInfo;

import java.io.IOException;


public class SerializerC extends StdSerializer<OrderInfo> {
    public SerializerC(){
        this(null);
    }

    public SerializerC(Class<OrderInfo> t) {
        super(t);
    }

    @Override
    public void serialize(OrderInfo orderInfo, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("CustomerName",orderInfo.getFullNameOfCustomer());
        jsonGenerator.writeStringField("OrderStatus", orderInfo.getOrderStatus());
        jsonGenerator.writeEndObject();
    }
}
