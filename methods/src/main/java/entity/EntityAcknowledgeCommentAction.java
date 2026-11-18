package entity;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.entity.EntityAcknowledgeCommentActionRequest;
import com.slack.api.methods.response.entity.EntityAcknowledgeCommentActionResponse;
import com.slack.api.model.EntityComment;
import com.slack.api.model.EntityMetadata;
import java.io.IOException;

public class EntityAcknowledgeCommentAction {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the entity.acknowledgeCommentAction method
        EntityAcknowledgeCommentActionRequest request = EntityAcknowledgeCommentActionRequest.builder()
                .triggerId("1234567890123.1234567890123.abcdef01234567890abcdef012345689")
                .comment(EntityComment.builder()
                        .id("comment-unique-identifier-003")
                        .sender(EntityMetadata.EntityPayload.User.builder()
                                .userId("U123456789")
                                .build())
                        .comment(EntityComment.Content.builder()
                                .value("The saved comment text")
                                .format("markdown")
                                .build())
                        .timestamp(1741164500)
                        .url("your.app/item/1/comment/3")
                        .threadRootId("comment-unique-identifier-001")
                        .build())
                .build();
        EntityAcknowledgeCommentActionResponse response = methods.entityAcknowledgeCommentAction(request);

        // Inspect the response
        System.out.println(response);
    }
}
