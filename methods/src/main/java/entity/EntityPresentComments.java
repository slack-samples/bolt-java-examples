package entity;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.entity.EntityPresentCommentsRequest;
import com.slack.api.methods.response.entity.EntityPresentCommentsResponse;
import com.slack.api.model.EntityComment;
import com.slack.api.model.EntityMetadata;
import com.slack.api.model.block.RichTextBlock;
import com.slack.api.model.block.element.RichTextSectionElement;
import java.io.IOException;
import java.util.Arrays;

public class EntityPresentComments {

    public static void main(String[] args) throws IOException, SlackApiException {
        // Read a token from an environment variable
        String token = System.getenv("SLACK_TOKEN");

        // Initialize
        MethodsClient methods = Slack.getInstance().methods(token);

        // Call the entity.presentComments method
        EntityPresentCommentsRequest request = EntityPresentCommentsRequest.builder()
                .comments(Arrays.asList(
                        EntityComment.builder()
                                .sender(EntityMetadata.EntityPayload.User.builder()
                                        .userId("U123456789")
                                        .build())
                                .timestamp(1741164235)
                                .id("comment-unique-identifier-001")
                                .url("your.app/item/1/comment/1")
                                .canEdit(true)
                                .canDelete(true)
                                .canReply(true)
                                .replyCount(2)
                                .replyUsers(Arrays.asList(
                                        EntityMetadata.EntityPayload.User.builder()
                                                .userId("U234567890")
                                                .build(),
                                        EntityMetadata.EntityPayload.User.builder()
                                                .text("External User")
                                                .icon(EntityMetadata.EntityPayload.Icon.builder()
                                                        .url("...")
                                                        .build())
                                                .build()))
                                .latestReplyTs(1741165000)
                                .lastEditTs(1741164300)
                                .comment(EntityComment.Content.builder()
                                        .blocks(RichTextBlock.builder()
                                                .elements(Arrays.asList(RichTextSectionElement.builder()
                                                        .elements(Arrays.asList(RichTextSectionElement.Text.builder()
                                                                .text(
                                                                        "Check out these different block types with paragraph breaks between them:\n\n")
                                                                .build()))
                                                        .build()))
                                                .build())
                                        .build())
                                .build(),
                        EntityComment.builder()
                                .sender(EntityMetadata.EntityPayload.User.builder()
                                        .text("UserFirstName UserLastName")
                                        .icon(EntityMetadata.EntityPayload.Icon.builder()
                                                .altText("Summary of image's content")
                                                .url("...")
                                                .build())
                                        .url("your.app/user/userId")
                                        .email("firstname.lastname@domain.com")
                                        .build())
                                .timestamp(1741164358)
                                .id("comment-unique-identifier-002")
                                .url("your.app/item/1/comment/2")
                                .threadRootId("comment-unique-identifier-001")
                                .comment(EntityComment.Content.builder()
                                        .value("Plain text comment")
                                        .format("markdown")
                                        .build())
                                .build()))
                .triggerId("1234567890123.1234567890123.abcdef01234567890abcdef012345689")
                .canPostComment(true)
                .deleteActionId("your-delete-action-id")
                .build();
        EntityPresentCommentsResponse response = methods.entityPresentComments(request);

        // Inspect the response
        System.out.println(response);
    }
}
