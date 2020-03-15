package Serial;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.govoronok.bstu.entity.Order;
import com.govoronok.bstu.entity.OrderInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeserializerC extends StdDeserializer<List> {

    public DeserializerC(){
        this(null);
    }

    public DeserializerC(JavaType valueType) {
        super(valueType);
    }

    @Override
    public List<OrderInfo> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);

        List<OrderInfo> orderInfos = new ArrayList<OrderInfo>(node.size());
        node.forEach(jsonNode->orderInfos.add(new OrderInfo(jsonNode.get("orderName").asText(),
                jsonNode.get("orderStatus").asText())));
        OrderInfo orderInfo = new OrderInfo("","");
        return orderInfos;
    }
}
