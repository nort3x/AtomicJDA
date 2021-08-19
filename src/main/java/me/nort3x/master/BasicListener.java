package me.nort3x.master;

import me.nort3x.atomic.logger.AtomicLogger;
import me.nort3x.atomic.logger.Priority;
import net.dv8tion.jda.api.events.*;
import net.dv8tion.jda.api.events.application.ApplicationCommandCreateEvent;
import net.dv8tion.jda.api.events.application.ApplicationCommandDeleteEvent;
import net.dv8tion.jda.api.events.application.ApplicationCommandUpdateEvent;
import net.dv8tion.jda.api.events.application.GenericApplicationCommandEvent;
import net.dv8tion.jda.api.events.channel.category.CategoryCreateEvent;
import net.dv8tion.jda.api.events.channel.category.CategoryDeleteEvent;
import net.dv8tion.jda.api.events.channel.category.GenericCategoryEvent;
import net.dv8tion.jda.api.events.channel.category.update.CategoryUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.category.update.CategoryUpdatePermissionsEvent;
import net.dv8tion.jda.api.events.channel.category.update.CategoryUpdatePositionEvent;
import net.dv8tion.jda.api.events.channel.category.update.GenericCategoryUpdateEvent;
import net.dv8tion.jda.api.events.channel.priv.PrivateChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.priv.PrivateChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.store.GenericStoreChannelEvent;
import net.dv8tion.jda.api.events.channel.store.StoreChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.store.StoreChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.store.update.GenericStoreChannelUpdateEvent;
import net.dv8tion.jda.api.events.channel.store.update.StoreChannelUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.store.update.StoreChannelUpdatePermissionsEvent;
import net.dv8tion.jda.api.events.channel.store.update.StoreChannelUpdatePositionEvent;
import net.dv8tion.jda.api.events.channel.text.GenericTextChannelEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.text.update.*;
import net.dv8tion.jda.api.events.channel.voice.GenericVoiceChannelEvent;
import net.dv8tion.jda.api.events.channel.voice.VoiceChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.voice.VoiceChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.voice.update.*;
import net.dv8tion.jda.api.events.emote.EmoteAddedEvent;
import net.dv8tion.jda.api.events.emote.EmoteRemovedEvent;
import net.dv8tion.jda.api.events.emote.GenericEmoteEvent;
import net.dv8tion.jda.api.events.emote.update.EmoteUpdateNameEvent;
import net.dv8tion.jda.api.events.emote.update.EmoteUpdateRolesEvent;
import net.dv8tion.jda.api.events.emote.update.GenericEmoteUpdateEvent;
import net.dv8tion.jda.api.events.guild.*;
import net.dv8tion.jda.api.events.guild.invite.GenericGuildInviteEvent;
import net.dv8tion.jda.api.events.guild.invite.GuildInviteCreateEvent;
import net.dv8tion.jda.api.events.guild.invite.GuildInviteDeleteEvent;
import net.dv8tion.jda.api.events.guild.member.*;
import net.dv8tion.jda.api.events.guild.member.update.GenericGuildMemberUpdateEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateBoostTimeEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdatePendingEvent;
import net.dv8tion.jda.api.events.guild.override.GenericPermissionOverrideEvent;
import net.dv8tion.jda.api.events.guild.override.PermissionOverrideCreateEvent;
import net.dv8tion.jda.api.events.guild.override.PermissionOverrideDeleteEvent;
import net.dv8tion.jda.api.events.guild.override.PermissionOverrideUpdateEvent;
import net.dv8tion.jda.api.events.guild.update.*;
import net.dv8tion.jda.api.events.guild.voice.*;
import net.dv8tion.jda.api.events.http.HttpRequestEvent;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.*;
import net.dv8tion.jda.api.events.message.guild.*;
import net.dv8tion.jda.api.events.message.guild.react.*;
import net.dv8tion.jda.api.events.message.priv.*;
import net.dv8tion.jda.api.events.message.priv.react.GenericPrivateMessageReactionEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.message.react.*;
import net.dv8tion.jda.api.events.role.GenericRoleEvent;
import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.events.role.RoleDeleteEvent;
import net.dv8tion.jda.api.events.role.update.*;
import net.dv8tion.jda.api.events.self.*;
import net.dv8tion.jda.api.events.user.GenericUserEvent;
import net.dv8tion.jda.api.events.user.UserActivityEndEvent;
import net.dv8tion.jda.api.events.user.UserActivityStartEvent;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.events.user.update.*;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

public class BasicListener extends ListenerAdapter {


    void addRule(Method m, Object o) {
        Parameter[] parameters = m.getParameters();
        if (parameters.length != 1) {
            AtomicLogger.getInstance().warning("Provided Rule is Not acceptable should Only have one Parameter of Event Type : " + m.getDeclaringClass().getName() + "." + m.getName(), Priority.VERY_IMPORTANT);
            return;
        }
        Class<?> type = parameters[0].getType();

        if (type.equals(TextChannelUpdatePermissionsEvent.class)) {
            TextChannelUpdatePermissionsEventRules.putIfAbsent(m, o);
        } else if (type.equals(StoreChannelUpdatePermissionsEvent.class)) {
            StoreChannelUpdatePermissionsEventRules.putIfAbsent(m, o);
        } else if (type.equals(VoiceChannelUpdatePermissionsEvent.class)) {
            VoiceChannelUpdatePermissionsEventRules.putIfAbsent(m, o);
        } else if (type.equals(CategoryUpdatePermissionsEvent.class)) {
            CategoryUpdatePermissionsEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildMemberLeaveEvent.class)) {
            GuildMemberLeaveEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericEvent.class)) {
            GenericEventRules.putIfAbsent(m, o);
        } else if (type.equals(UpdateEvent.class)) {
            UpdateEventRules.putIfAbsent(m, o);
        } else if (type.equals(RawGatewayEvent.class)) {
            RawGatewayEventRules.putIfAbsent(m, o);
        } else if (type.equals(GatewayPingEvent.class)) {
            GatewayPingEventRules.putIfAbsent(m, o);
        } else if (type.equals(ReadyEvent.class)) {
            ReadyEventRules.putIfAbsent(m, o);
        } else if (type.equals(ResumedEvent.class)) {
            ResumedEventRules.putIfAbsent(m, o);
        } else if (type.equals(ReconnectedEvent.class)) {
            ReconnectedEventRules.putIfAbsent(m, o);
        } else if (type.equals(DisconnectEvent.class)) {
            DisconnectEventRules.putIfAbsent(m, o);
        } else if (type.equals(ShutdownEvent.class)) {
            ShutdownEventRules.putIfAbsent(m, o);
        } else if (type.equals(StatusChangeEvent.class)) {
            StatusChangeEventRules.putIfAbsent(m, o);
        } else if (type.equals(ExceptionEvent.class)) {
            ExceptionEventRules.putIfAbsent(m, o);
        } else if (type.equals(SlashCommandEvent.class)) {
            SlashCommandEventRules.putIfAbsent(m, o);
        } else if (type.equals(ButtonClickEvent.class)) {
            ButtonClickEventRules.putIfAbsent(m, o);
        } else if (type.equals(ApplicationCommandUpdateEvent.class)) {
            ApplicationCommandUpdateEventRules.putIfAbsent(m, o);
        } else if (type.equals(ApplicationCommandDeleteEvent.class)) {
            ApplicationCommandDeleteEventRules.putIfAbsent(m, o);
        } else if (type.equals(ApplicationCommandCreateEvent.class)) {
            ApplicationCommandCreateEventRules.putIfAbsent(m, o);
        } else if (type.equals(UserUpdateNameEvent.class)) {
            UserUpdateNameEventRules.putIfAbsent(m, o);
        } else if (type.equals(UserUpdateDiscriminatorEvent.class)) {
            UserUpdateDiscriminatorEventRules.putIfAbsent(m, o);
        } else if (type.equals(UserUpdateAvatarEvent.class)) {
            UserUpdateAvatarEventRules.putIfAbsent(m, o);
        } else if (type.equals(UserUpdateOnlineStatusEvent.class)) {
            UserUpdateOnlineStatusEventRules.putIfAbsent(m, o);
        } else if (type.equals(UserUpdateActivityOrderEvent.class)) {
            UserUpdateActivityOrderEventRules.putIfAbsent(m, o);
        } else if (type.equals(UserUpdateFlagsEvent.class)) {
            UserUpdateFlagsEventRules.putIfAbsent(m, o);
        } else if (type.equals(UserTypingEvent.class)) {
            UserTypingEventRules.putIfAbsent(m, o);
        } else if (type.equals(UserActivityStartEvent.class)) {
            UserActivityStartEventRules.putIfAbsent(m, o);
        } else if (type.equals(UserActivityEndEvent.class)) {
            UserActivityEndEventRules.putIfAbsent(m, o);
        } else if (type.equals(UserUpdateActivitiesEvent.class)) {
            UserUpdateActivitiesEventRules.putIfAbsent(m, o);
        } else if (type.equals(SelfUpdateAvatarEvent.class)) {
            SelfUpdateAvatarEventRules.putIfAbsent(m, o);
        } else if (type.equals(SelfUpdateMFAEvent.class)) {
            SelfUpdateMFAEventRules.putIfAbsent(m, o);
        } else if (type.equals(SelfUpdateNameEvent.class)) {
            SelfUpdateNameEventRules.putIfAbsent(m, o);
        } else if (type.equals(SelfUpdateVerifiedEvent.class)) {
            SelfUpdateVerifiedEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildMessageReceivedEvent.class)) {
            GuildMessageReceivedEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildMessageUpdateEvent.class)) {
            GuildMessageUpdateEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildMessageDeleteEvent.class)) {
            GuildMessageDeleteEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildMessageEmbedEvent.class)) {
            GuildMessageEmbedEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildMessageReactionAddEvent.class)) {
            GuildMessageReactionAddEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildMessageReactionRemoveEvent.class)) {
            GuildMessageReactionRemoveEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildMessageReactionRemoveAllEvent.class)) {
            GuildMessageReactionRemoveAllEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildMessageReactionRemoveEmoteEvent.class)) {
            GuildMessageReactionRemoveEmoteEventRules.putIfAbsent(m, o);
        } else if (type.equals(PrivateMessageReceivedEvent.class)) {
            PrivateMessageReceivedEventRules.putIfAbsent(m, o);
        } else if (type.equals(PrivateMessageUpdateEvent.class)) {
            PrivateMessageUpdateEventRules.putIfAbsent(m, o);
        } else if (type.equals(PrivateMessageDeleteEvent.class)) {
            PrivateMessageDeleteEventRules.putIfAbsent(m, o);
        } else if (type.equals(PrivateMessageEmbedEvent.class)) {
            PrivateMessageEmbedEventRules.putIfAbsent(m, o);
        } else if (type.equals(PrivateMessageReactionAddEvent.class)) {
            PrivateMessageReactionAddEventRules.putIfAbsent(m, o);
        } else if (type.equals(PrivateMessageReactionRemoveEvent.class)) {
            PrivateMessageReactionRemoveEventRules.putIfAbsent(m, o);
        } else if (type.equals(MessageReceivedEvent.class)) {
            MessageReceivedEventRules.putIfAbsent(m, o);
        } else if (type.equals(MessageUpdateEvent.class)) {
            MessageUpdateEventRules.putIfAbsent(m, o);
        } else if (type.equals(MessageDeleteEvent.class)) {
            MessageDeleteEventRules.putIfAbsent(m, o);
        } else if (type.equals(MessageBulkDeleteEvent.class)) {
            MessageBulkDeleteEventRules.putIfAbsent(m, o);
        } else if (type.equals(MessageEmbedEvent.class)) {
            MessageEmbedEventRules.putIfAbsent(m, o);
        } else if (type.equals(MessageReactionAddEvent.class)) {
            MessageReactionAddEventRules.putIfAbsent(m, o);
        } else if (type.equals(MessageReactionRemoveEvent.class)) {
            MessageReactionRemoveEventRules.putIfAbsent(m, o);
        } else if (type.equals(MessageReactionRemoveAllEvent.class)) {
            MessageReactionRemoveAllEventRules.putIfAbsent(m, o);
        } else if (type.equals(MessageReactionRemoveEmoteEvent.class)) {
            MessageReactionRemoveEmoteEventRules.putIfAbsent(m, o);
        } else if (type.equals(PermissionOverrideDeleteEvent.class)) {
            PermissionOverrideDeleteEventRules.putIfAbsent(m, o);
        } else if (type.equals(PermissionOverrideUpdateEvent.class)) {
            PermissionOverrideUpdateEventRules.putIfAbsent(m, o);
        } else if (type.equals(PermissionOverrideCreateEvent.class)) {
            PermissionOverrideCreateEventRules.putIfAbsent(m, o);
        } else if (type.equals(StoreChannelDeleteEvent.class)) {
            StoreChannelDeleteEventRules.putIfAbsent(m, o);
        } else if (type.equals(StoreChannelUpdateNameEvent.class)) {
            StoreChannelUpdateNameEventRules.putIfAbsent(m, o);
        } else if (type.equals(StoreChannelUpdatePositionEvent.class)) {
            StoreChannelUpdatePositionEventRules.putIfAbsent(m, o);
        } else if (type.equals(StoreChannelCreateEvent.class)) {
            StoreChannelCreateEventRules.putIfAbsent(m, o);
        } else if (type.equals(TextChannelDeleteEvent.class)) {
            TextChannelDeleteEventRules.putIfAbsent(m, o);
        } else if (type.equals(TextChannelUpdateNameEvent.class)) {
            TextChannelUpdateNameEventRules.putIfAbsent(m, o);
        } else if (type.equals(TextChannelUpdateTopicEvent.class)) {
            TextChannelUpdateTopicEventRules.putIfAbsent(m, o);
        } else if (type.equals(TextChannelUpdatePositionEvent.class)) {
            TextChannelUpdatePositionEventRules.putIfAbsent(m, o);
        } else if (type.equals(TextChannelUpdateNSFWEvent.class)) {
            TextChannelUpdateNSFWEventRules.putIfAbsent(m, o);
        } else if (type.equals(TextChannelUpdateParentEvent.class)) {
            TextChannelUpdateParentEventRules.putIfAbsent(m, o);
        } else if (type.equals(TextChannelUpdateSlowmodeEvent.class)) {
            TextChannelUpdateSlowmodeEventRules.putIfAbsent(m, o);
        } else if (type.equals(TextChannelUpdateNewsEvent.class)) {
            TextChannelUpdateNewsEventRules.putIfAbsent(m, o);
        } else if (type.equals(TextChannelCreateEvent.class)) {
            TextChannelCreateEventRules.putIfAbsent(m, o);
        } else if (type.equals(VoiceChannelDeleteEvent.class)) {
            VoiceChannelDeleteEventRules.putIfAbsent(m, o);
        } else if (type.equals(VoiceChannelUpdateNameEvent.class)) {
            VoiceChannelUpdateNameEventRules.putIfAbsent(m, o);
        } else if (type.equals(VoiceChannelUpdatePositionEvent.class)) {
            VoiceChannelUpdatePositionEventRules.putIfAbsent(m, o);
        } else if (type.equals(VoiceChannelUpdateUserLimitEvent.class)) {
            VoiceChannelUpdateUserLimitEventRules.putIfAbsent(m, o);
        } else if (type.equals(VoiceChannelUpdateBitrateEvent.class)) {
            VoiceChannelUpdateBitrateEventRules.putIfAbsent(m, o);
        } else if (type.equals(VoiceChannelUpdateParentEvent.class)) {
            VoiceChannelUpdateParentEventRules.putIfAbsent(m, o);
        } else if (type.equals(VoiceChannelUpdateRegionEvent.class)) {
            VoiceChannelUpdateRegionEventRules.putIfAbsent(m, o);
        } else if (type.equals(VoiceChannelCreateEvent.class)) {
            VoiceChannelCreateEventRules.putIfAbsent(m, o);
        } else if (type.equals(CategoryDeleteEvent.class)) {
            CategoryDeleteEventRules.putIfAbsent(m, o);
        } else if (type.equals(CategoryUpdateNameEvent.class)) {
            CategoryUpdateNameEventRules.putIfAbsent(m, o);
        } else if (type.equals(CategoryUpdatePositionEvent.class)) {
            CategoryUpdatePositionEventRules.putIfAbsent(m, o);
        } else if (type.equals(CategoryCreateEvent.class)) {
            CategoryCreateEventRules.putIfAbsent(m, o);
        } else if (type.equals(PrivateChannelCreateEvent.class)) {
            PrivateChannelCreateEventRules.putIfAbsent(m, o);
        } else if (type.equals(PrivateChannelDeleteEvent.class)) {
            PrivateChannelDeleteEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildReadyEvent.class)) {
            GuildReadyEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildTimeoutEvent.class)) {
            GuildTimeoutEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildJoinEvent.class)) {
            GuildJoinEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildLeaveEvent.class)) {
            GuildLeaveEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildAvailableEvent.class)) {
            GuildAvailableEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUnavailableEvent.class)) {
            GuildUnavailableEventRules.putIfAbsent(m, o);
        } else if (type.equals(UnavailableGuildJoinedEvent.class)) {
            UnavailableGuildJoinedEventRules.putIfAbsent(m, o);
        } else if (type.equals(UnavailableGuildLeaveEvent.class)) {
            UnavailableGuildLeaveEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildBanEvent.class)) {
            GuildBanEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUnbanEvent.class)) {
            GuildUnbanEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildMemberRemoveEvent.class)) {
            GuildMemberRemoveEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateAfkChannelEvent.class)) {
            GuildUpdateAfkChannelEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateSystemChannelEvent.class)) {
            GuildUpdateSystemChannelEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateRulesChannelEvent.class)) {
            GuildUpdateRulesChannelEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateCommunityUpdatesChannelEvent.class)) {
            GuildUpdateCommunityUpdatesChannelEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateAfkTimeoutEvent.class)) {
            GuildUpdateAfkTimeoutEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateExplicitContentLevelEvent.class)) {
            GuildUpdateExplicitContentLevelEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateIconEvent.class)) {
            GuildUpdateIconEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateMFALevelEvent.class)) {
            GuildUpdateMFALevelEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateNameEvent.class)) {
            GuildUpdateNameEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateNotificationLevelEvent.class)) {
            GuildUpdateNotificationLevelEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateOwnerEvent.class)) {
            GuildUpdateOwnerEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateRegionEvent.class)) {
            GuildUpdateRegionEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateSplashEvent.class)) {
            GuildUpdateSplashEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateVerificationLevelEvent.class)) {
            GuildUpdateVerificationLevelEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateLocaleEvent.class)) {
            GuildUpdateLocaleEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateFeaturesEvent.class)) {
            GuildUpdateFeaturesEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateVanityCodeEvent.class)) {
            GuildUpdateVanityCodeEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateBannerEvent.class)) {
            GuildUpdateBannerEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateDescriptionEvent.class)) {
            GuildUpdateDescriptionEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateBoostTierEvent.class)) {
            GuildUpdateBoostTierEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateBoostCountEvent.class)) {
            GuildUpdateBoostCountEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateMaxMembersEvent.class)) {
            GuildUpdateMaxMembersEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildUpdateMaxPresencesEvent.class)) {
            GuildUpdateMaxPresencesEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildInviteCreateEvent.class)) {
            GuildInviteCreateEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildInviteDeleteEvent.class)) {
            GuildInviteDeleteEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildMemberJoinEvent.class)) {
            GuildMemberJoinEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildMemberRoleAddEvent.class)) {
            GuildMemberRoleAddEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildMemberRoleRemoveEvent.class)) {
            GuildMemberRoleRemoveEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildMemberUpdateEvent.class)) {
            GuildMemberUpdateEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildMemberUpdateNicknameEvent.class)) {
            GuildMemberUpdateNicknameEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildMemberUpdateBoostTimeEvent.class)) {
            GuildMemberUpdateBoostTimeEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildMemberUpdatePendingEvent.class)) {
            GuildMemberUpdatePendingEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildVoiceUpdateEvent.class)) {
            GuildVoiceUpdateEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildVoiceJoinEvent.class)) {
            GuildVoiceJoinEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildVoiceMoveEvent.class)) {
            GuildVoiceMoveEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildVoiceLeaveEvent.class)) {
            GuildVoiceLeaveEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildVoiceMuteEvent.class)) {
            GuildVoiceMuteEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildVoiceDeafenEvent.class)) {
            GuildVoiceDeafenEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildVoiceGuildMuteEvent.class)) {
            GuildVoiceGuildMuteEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildVoiceGuildDeafenEvent.class)) {
            GuildVoiceGuildDeafenEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildVoiceSelfMuteEvent.class)) {
            GuildVoiceSelfMuteEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildVoiceSelfDeafenEvent.class)) {
            GuildVoiceSelfDeafenEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildVoiceSuppressEvent.class)) {
            GuildVoiceSuppressEventRules.putIfAbsent(m, o);
        } else if (type.equals(GuildVoiceStreamEvent.class)) {
            GuildVoiceStreamEventRules.putIfAbsent(m, o);
        } else if (type.equals(RoleCreateEvent.class)) {
            RoleCreateEventRules.putIfAbsent(m, o);
        } else if (type.equals(RoleDeleteEvent.class)) {
            RoleDeleteEventRules.putIfAbsent(m, o);
        } else if (type.equals(RoleUpdateColorEvent.class)) {
            RoleUpdateColorEventRules.putIfAbsent(m, o);
        } else if (type.equals(RoleUpdateHoistedEvent.class)) {
            RoleUpdateHoistedEventRules.putIfAbsent(m, o);
        } else if (type.equals(RoleUpdateMentionableEvent.class)) {
            RoleUpdateMentionableEventRules.putIfAbsent(m, o);
        } else if (type.equals(RoleUpdateNameEvent.class)) {
            RoleUpdateNameEventRules.putIfAbsent(m, o);
        } else if (type.equals(RoleUpdatePermissionsEvent.class)) {
            RoleUpdatePermissionsEventRules.putIfAbsent(m, o);
        } else if (type.equals(RoleUpdatePositionEvent.class)) {
            RoleUpdatePositionEventRules.putIfAbsent(m, o);
        } else if (type.equals(EmoteAddedEvent.class)) {
            EmoteAddedEventRules.putIfAbsent(m, o);
        } else if (type.equals(EmoteRemovedEvent.class)) {
            EmoteRemovedEventRules.putIfAbsent(m, o);
        } else if (type.equals(EmoteUpdateNameEvent.class)) {
            EmoteUpdateNameEventRules.putIfAbsent(m, o);
        } else if (type.equals(EmoteUpdateRolesEvent.class)) {
            EmoteUpdateRolesEventRules.putIfAbsent(m, o);
        } else if (type.equals(HttpRequestEvent.class)) {
            HttpRequestEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericApplicationCommandEvent.class)) {
            GenericApplicationCommandEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericInteractionCreateEvent.class)) {
            GenericInteractionCreateEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericMessageEvent.class)) {
            GenericMessageEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericMessageReactionEvent.class)) {
            GenericMessageReactionEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericGuildMessageEvent.class)) {
            GenericGuildMessageEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericGuildMessageReactionEvent.class)) {
            GenericGuildMessageReactionEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericPrivateMessageEvent.class)) {
            GenericPrivateMessageEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericPrivateMessageReactionEvent.class)) {
            GenericPrivateMessageReactionEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericUserEvent.class)) {
            GenericUserEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericUserPresenceEvent.class)) {
            GenericUserPresenceEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericSelfUpdateEvent.class)) {
            GenericSelfUpdateEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericStoreChannelEvent.class)) {
            GenericStoreChannelEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericStoreChannelUpdateEvent.class)) {
            GenericStoreChannelUpdateEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericTextChannelEvent.class)) {
            GenericTextChannelEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericTextChannelUpdateEvent.class)) {
            GenericTextChannelUpdateEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericVoiceChannelEvent.class)) {
            GenericVoiceChannelEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericVoiceChannelUpdateEvent.class)) {
            GenericVoiceChannelUpdateEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericCategoryEvent.class)) {
            GenericCategoryEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericCategoryUpdateEvent.class)) {
            GenericCategoryUpdateEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericGuildEvent.class)) {
            GenericGuildEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericGuildUpdateEvent.class)) {
            GenericGuildUpdateEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericGuildInviteEvent.class)) {
            GenericGuildInviteEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericGuildMemberEvent.class)) {
            GenericGuildMemberEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericGuildMemberUpdateEvent.class)) {
            GenericGuildMemberUpdateEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericGuildVoiceEvent.class)) {
            GenericGuildVoiceEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericRoleEvent.class)) {
            GenericRoleEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericRoleUpdateEvent.class)) {
            GenericRoleUpdateEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericEmoteEvent.class)) {
            GenericEmoteEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericEmoteUpdateEvent.class)) {
            GenericEmoteUpdateEventRules.putIfAbsent(m, o);
        } else if (type.equals(GenericPermissionOverrideEvent.class)) {
            GenericPermissionOverrideEventRules.putIfAbsent(m, o);
        }else{
            AtomicLogger.getInstance().warning("Rule Type is not recognizable: "+m.getDeclaringClass().getName() + "." + m.getName() + " has the parameter type: "+ type.getName(),Priority.VERY_IMPORTANT);
        }

    }

    Map<Method, Object> TextChannelUpdatePermissionsEventRules = new HashMap<>();

    @Override
    public void onTextChannelUpdatePermissions(@NotNull TextChannelUpdatePermissionsEvent event) {
        TextChannelUpdatePermissionsEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> StoreChannelUpdatePermissionsEventRules = new HashMap<>();

    @Override
    public void onStoreChannelUpdatePermissions(@NotNull StoreChannelUpdatePermissionsEvent event) {
        StoreChannelUpdatePermissionsEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> VoiceChannelUpdatePermissionsEventRules = new HashMap<>();

    @Override
    public void onVoiceChannelUpdatePermissions(@NotNull VoiceChannelUpdatePermissionsEvent event) {
        VoiceChannelUpdatePermissionsEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> CategoryUpdatePermissionsEventRules = new HashMap<>();

    @Override
    public void onCategoryUpdatePermissions(@NotNull CategoryUpdatePermissionsEvent event) {
        CategoryUpdatePermissionsEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildMemberLeaveEventRules = new HashMap<>();

    @Override
    public void onGuildMemberLeave(@NotNull GuildMemberLeaveEvent event) {
        GuildMemberLeaveEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericEventRules = new HashMap<>();

    @Override
    public void onGenericEvent(@NotNull GenericEvent event) {
        GenericEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> UpdateEventRules = new HashMap<>();

    @Override
    public void onGenericUpdate(@NotNull UpdateEvent<?, ?> event) {
        UpdateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> RawGatewayEventRules = new HashMap<>();

    @Override
    public void onRawGateway(@NotNull RawGatewayEvent event) {
        RawGatewayEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GatewayPingEventRules = new HashMap<>();

    @Override
    public void onGatewayPing(@NotNull GatewayPingEvent event) {
        GatewayPingEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> ReadyEventRules = new HashMap<>();

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        ReadyEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> ResumedEventRules = new HashMap<>();

    @Override
    public void onResumed(@NotNull ResumedEvent event) {
        ResumedEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> ReconnectedEventRules = new HashMap<>();

    @Override
    public void onReconnected(@NotNull ReconnectedEvent event) {
        ReconnectedEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> DisconnectEventRules = new HashMap<>();

    @Override
    public void onDisconnect(@NotNull DisconnectEvent event) {
        DisconnectEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> ShutdownEventRules = new HashMap<>();

    @Override
    public void onShutdown(@NotNull ShutdownEvent event) {
        ShutdownEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> StatusChangeEventRules = new HashMap<>();

    @Override
    public void onStatusChange(@NotNull StatusChangeEvent event) {
        StatusChangeEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> ExceptionEventRules = new HashMap<>();

    @Override
    public void onException(@NotNull ExceptionEvent event) {
        ExceptionEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> SlashCommandEventRules = new HashMap<>();

    @Override
    public void onSlashCommand(@NotNull SlashCommandEvent event) {
        SlashCommandEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> ButtonClickEventRules = new HashMap<>();

    @Override
    public void onButtonClick(@NotNull ButtonClickEvent event) {
        ButtonClickEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> ApplicationCommandUpdateEventRules = new HashMap<>();

    @Override
    public void onApplicationCommandUpdate(@NotNull ApplicationCommandUpdateEvent event) {
        ApplicationCommandUpdateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> ApplicationCommandDeleteEventRules = new HashMap<>();

    @Override
    public void onApplicationCommandDelete(@NotNull ApplicationCommandDeleteEvent event) {
        ApplicationCommandDeleteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> ApplicationCommandCreateEventRules = new HashMap<>();

    @Override
    public void onApplicationCommandCreate(@NotNull ApplicationCommandCreateEvent event) {
        ApplicationCommandCreateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> UserUpdateNameEventRules = new HashMap<>();

    @Override
    public void onUserUpdateName(@NotNull UserUpdateNameEvent event) {
        UserUpdateNameEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> UserUpdateDiscriminatorEventRules = new HashMap<>();

    @Override
    public void onUserUpdateDiscriminator(@NotNull UserUpdateDiscriminatorEvent event) {
        UserUpdateDiscriminatorEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> UserUpdateAvatarEventRules = new HashMap<>();

    @Override
    public void onUserUpdateAvatar(@NotNull UserUpdateAvatarEvent event) {
        UserUpdateAvatarEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> UserUpdateOnlineStatusEventRules = new HashMap<>();

    @Override
    public void onUserUpdateOnlineStatus(@NotNull UserUpdateOnlineStatusEvent event) {
        UserUpdateOnlineStatusEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> UserUpdateActivityOrderEventRules = new HashMap<>();

    @Override
    public void onUserUpdateActivityOrder(@NotNull UserUpdateActivityOrderEvent event) {
        UserUpdateActivityOrderEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> UserUpdateFlagsEventRules = new HashMap<>();

    @Override
    public void onUserUpdateFlags(@NotNull UserUpdateFlagsEvent event) {
        UserUpdateFlagsEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> UserTypingEventRules = new HashMap<>();

    @Override
    public void onUserTyping(@NotNull UserTypingEvent event) {
        UserTypingEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> UserActivityStartEventRules = new HashMap<>();

    @Override
    public void onUserActivityStart(@NotNull UserActivityStartEvent event) {
        UserActivityStartEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> UserActivityEndEventRules = new HashMap<>();

    @Override
    public void onUserActivityEnd(@NotNull UserActivityEndEvent event) {
        UserActivityEndEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> UserUpdateActivitiesEventRules = new HashMap<>();

    @Override
    public void onUserUpdateActivities(@NotNull UserUpdateActivitiesEvent event) {
        UserUpdateActivitiesEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> SelfUpdateAvatarEventRules = new HashMap<>();

    @Override
    public void onSelfUpdateAvatar(@NotNull SelfUpdateAvatarEvent event) {
        SelfUpdateAvatarEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> SelfUpdateMFAEventRules = new HashMap<>();

    @Override
    public void onSelfUpdateMFA(@NotNull SelfUpdateMFAEvent event) {
        SelfUpdateMFAEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> SelfUpdateNameEventRules = new HashMap<>();

    @Override
    public void onSelfUpdateName(@NotNull SelfUpdateNameEvent event) {
        SelfUpdateNameEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> SelfUpdateVerifiedEventRules = new HashMap<>();

    @Override
    public void onSelfUpdateVerified(@NotNull SelfUpdateVerifiedEvent event) {
        SelfUpdateVerifiedEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildMessageReceivedEventRules = new HashMap<>();

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        GuildMessageReceivedEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildMessageUpdateEventRules = new HashMap<>();

    @Override
    public void onGuildMessageUpdate(@NotNull GuildMessageUpdateEvent event) {
        GuildMessageUpdateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildMessageDeleteEventRules = new HashMap<>();

    @Override
    public void onGuildMessageDelete(@NotNull GuildMessageDeleteEvent event) {
        GuildMessageDeleteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildMessageEmbedEventRules = new HashMap<>();

    @Override
    public void onGuildMessageEmbed(@NotNull GuildMessageEmbedEvent event) {
        GuildMessageEmbedEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildMessageReactionAddEventRules = new HashMap<>();

    @Override
    public void onGuildMessageReactionAdd(@NotNull GuildMessageReactionAddEvent event) {
        GuildMessageReactionAddEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildMessageReactionRemoveEventRules = new HashMap<>();

    @Override
    public void onGuildMessageReactionRemove(@NotNull GuildMessageReactionRemoveEvent event) {
        GuildMessageReactionRemoveEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildMessageReactionRemoveAllEventRules = new HashMap<>();

    @Override
    public void onGuildMessageReactionRemoveAll(@NotNull GuildMessageReactionRemoveAllEvent event) {
        GuildMessageReactionRemoveAllEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildMessageReactionRemoveEmoteEventRules = new HashMap<>();

    @Override
    public void onGuildMessageReactionRemoveEmote(@NotNull GuildMessageReactionRemoveEmoteEvent event) {
        GuildMessageReactionRemoveEmoteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> PrivateMessageReceivedEventRules = new HashMap<>();

    @Override
    public void onPrivateMessageReceived(@NotNull PrivateMessageReceivedEvent event) {
        PrivateMessageReceivedEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> PrivateMessageUpdateEventRules = new HashMap<>();

    @Override
    public void onPrivateMessageUpdate(@NotNull PrivateMessageUpdateEvent event) {
        PrivateMessageUpdateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> PrivateMessageDeleteEventRules = new HashMap<>();

    @Override
    public void onPrivateMessageDelete(@NotNull PrivateMessageDeleteEvent event) {
        PrivateMessageDeleteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> PrivateMessageEmbedEventRules = new HashMap<>();

    @Override
    public void onPrivateMessageEmbed(@NotNull PrivateMessageEmbedEvent event) {
        PrivateMessageEmbedEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> PrivateMessageReactionAddEventRules = new HashMap<>();

    @Override
    public void onPrivateMessageReactionAdd(@NotNull PrivateMessageReactionAddEvent event) {
        PrivateMessageReactionAddEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> PrivateMessageReactionRemoveEventRules = new HashMap<>();

    @Override
    public void onPrivateMessageReactionRemove(@NotNull PrivateMessageReactionRemoveEvent event) {
        PrivateMessageReactionRemoveEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> MessageReceivedEventRules = new HashMap<>();

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        MessageReceivedEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> MessageUpdateEventRules = new HashMap<>();

    @Override
    public void onMessageUpdate(@NotNull MessageUpdateEvent event) {
        MessageUpdateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> MessageDeleteEventRules = new HashMap<>();

    @Override
    public void onMessageDelete(@NotNull MessageDeleteEvent event) {
        MessageDeleteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> MessageBulkDeleteEventRules = new HashMap<>();

    @Override
    public void onMessageBulkDelete(@NotNull MessageBulkDeleteEvent event) {
        MessageBulkDeleteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> MessageEmbedEventRules = new HashMap<>();

    @Override
    public void onMessageEmbed(@NotNull MessageEmbedEvent event) {
        MessageEmbedEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> MessageReactionAddEventRules = new HashMap<>();

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        MessageReactionAddEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> MessageReactionRemoveEventRules = new HashMap<>();

    @Override
    public void onMessageReactionRemove(@NotNull MessageReactionRemoveEvent event) {
        MessageReactionRemoveEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> MessageReactionRemoveAllEventRules = new HashMap<>();

    @Override
    public void onMessageReactionRemoveAll(@NotNull MessageReactionRemoveAllEvent event) {
        MessageReactionRemoveAllEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> MessageReactionRemoveEmoteEventRules = new HashMap<>();

    @Override
    public void onMessageReactionRemoveEmote(@NotNull MessageReactionRemoveEmoteEvent event) {
        MessageReactionRemoveEmoteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> PermissionOverrideDeleteEventRules = new HashMap<>();

    @Override
    public void onPermissionOverrideDelete(@NotNull PermissionOverrideDeleteEvent event) {
        PermissionOverrideDeleteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> PermissionOverrideUpdateEventRules = new HashMap<>();

    @Override
    public void onPermissionOverrideUpdate(@NotNull PermissionOverrideUpdateEvent event) {
        PermissionOverrideUpdateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> PermissionOverrideCreateEventRules = new HashMap<>();

    @Override
    public void onPermissionOverrideCreate(@NotNull PermissionOverrideCreateEvent event) {
        PermissionOverrideCreateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> StoreChannelDeleteEventRules = new HashMap<>();

    @Override
    public void onStoreChannelDelete(@NotNull StoreChannelDeleteEvent event) {
        StoreChannelDeleteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> StoreChannelUpdateNameEventRules = new HashMap<>();

    @Override
    public void onStoreChannelUpdateName(@NotNull StoreChannelUpdateNameEvent event) {
        StoreChannelUpdateNameEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> StoreChannelUpdatePositionEventRules = new HashMap<>();

    @Override
    public void onStoreChannelUpdatePosition(@NotNull StoreChannelUpdatePositionEvent event) {
        StoreChannelUpdatePositionEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> StoreChannelCreateEventRules = new HashMap<>();

    @Override
    public void onStoreChannelCreate(@NotNull StoreChannelCreateEvent event) {
        StoreChannelCreateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> TextChannelDeleteEventRules = new HashMap<>();

    @Override
    public void onTextChannelDelete(@NotNull TextChannelDeleteEvent event) {
        TextChannelDeleteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> TextChannelUpdateNameEventRules = new HashMap<>();

    @Override
    public void onTextChannelUpdateName(@NotNull TextChannelUpdateNameEvent event) {
        TextChannelUpdateNameEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> TextChannelUpdateTopicEventRules = new HashMap<>();

    @Override
    public void onTextChannelUpdateTopic(@NotNull TextChannelUpdateTopicEvent event) {
        TextChannelUpdateTopicEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> TextChannelUpdatePositionEventRules = new HashMap<>();

    @Override
    public void onTextChannelUpdatePosition(@NotNull TextChannelUpdatePositionEvent event) {
        TextChannelUpdatePositionEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> TextChannelUpdateNSFWEventRules = new HashMap<>();

    @Override
    public void onTextChannelUpdateNSFW(@NotNull TextChannelUpdateNSFWEvent event) {
        TextChannelUpdateNSFWEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> TextChannelUpdateParentEventRules = new HashMap<>();

    @Override
    public void onTextChannelUpdateParent(@NotNull TextChannelUpdateParentEvent event) {
        TextChannelUpdateParentEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> TextChannelUpdateSlowmodeEventRules = new HashMap<>();

    @Override
    public void onTextChannelUpdateSlowmode(@NotNull TextChannelUpdateSlowmodeEvent event) {
        TextChannelUpdateSlowmodeEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> TextChannelUpdateNewsEventRules = new HashMap<>();

    @Override
    public void onTextChannelUpdateNews(@NotNull TextChannelUpdateNewsEvent event) {
        TextChannelUpdateNewsEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> TextChannelCreateEventRules = new HashMap<>();

    @Override
    public void onTextChannelCreate(@NotNull TextChannelCreateEvent event) {
        TextChannelCreateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> VoiceChannelDeleteEventRules = new HashMap<>();

    @Override
    public void onVoiceChannelDelete(@NotNull VoiceChannelDeleteEvent event) {
        VoiceChannelDeleteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> VoiceChannelUpdateNameEventRules = new HashMap<>();

    @Override
    public void onVoiceChannelUpdateName(@NotNull VoiceChannelUpdateNameEvent event) {
        VoiceChannelUpdateNameEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> VoiceChannelUpdatePositionEventRules = new HashMap<>();

    @Override
    public void onVoiceChannelUpdatePosition(@NotNull VoiceChannelUpdatePositionEvent event) {
        VoiceChannelUpdatePositionEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> VoiceChannelUpdateUserLimitEventRules = new HashMap<>();

    @Override
    public void onVoiceChannelUpdateUserLimit(@NotNull VoiceChannelUpdateUserLimitEvent event) {
        VoiceChannelUpdateUserLimitEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> VoiceChannelUpdateBitrateEventRules = new HashMap<>();

    @Override
    public void onVoiceChannelUpdateBitrate(@NotNull VoiceChannelUpdateBitrateEvent event) {
        VoiceChannelUpdateBitrateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> VoiceChannelUpdateParentEventRules = new HashMap<>();

    @Override
    public void onVoiceChannelUpdateParent(@NotNull VoiceChannelUpdateParentEvent event) {
        VoiceChannelUpdateParentEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> VoiceChannelUpdateRegionEventRules = new HashMap<>();

    @Override
    public void onVoiceChannelUpdateRegion(@NotNull VoiceChannelUpdateRegionEvent event) {
        VoiceChannelUpdateRegionEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> VoiceChannelCreateEventRules = new HashMap<>();

    @Override
    public void onVoiceChannelCreate(@NotNull VoiceChannelCreateEvent event) {
        VoiceChannelCreateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> CategoryDeleteEventRules = new HashMap<>();

    @Override
    public void onCategoryDelete(@NotNull CategoryDeleteEvent event) {
        CategoryDeleteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> CategoryUpdateNameEventRules = new HashMap<>();

    @Override
    public void onCategoryUpdateName(@NotNull CategoryUpdateNameEvent event) {
        CategoryUpdateNameEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> CategoryUpdatePositionEventRules = new HashMap<>();

    @Override
    public void onCategoryUpdatePosition(@NotNull CategoryUpdatePositionEvent event) {
        CategoryUpdatePositionEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> CategoryCreateEventRules = new HashMap<>();

    @Override
    public void onCategoryCreate(@NotNull CategoryCreateEvent event) {
        CategoryCreateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> PrivateChannelCreateEventRules = new HashMap<>();

    @Override
    public void onPrivateChannelCreate(@NotNull PrivateChannelCreateEvent event) {
        PrivateChannelCreateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> PrivateChannelDeleteEventRules = new HashMap<>();

    @Override
    public void onPrivateChannelDelete(@NotNull PrivateChannelDeleteEvent event) {
        PrivateChannelDeleteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildReadyEventRules = new HashMap<>();

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        GuildReadyEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildTimeoutEventRules = new HashMap<>();

    @Override
    public void onGuildTimeout(@NotNull GuildTimeoutEvent event) {
        GuildTimeoutEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildJoinEventRules = new HashMap<>();

    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        GuildJoinEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildLeaveEventRules = new HashMap<>();

    @Override
    public void onGuildLeave(@NotNull GuildLeaveEvent event) {
        GuildLeaveEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildAvailableEventRules = new HashMap<>();

    @Override
    public void onGuildAvailable(@NotNull GuildAvailableEvent event) {
        GuildAvailableEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUnavailableEventRules = new HashMap<>();

    @Override
    public void onGuildUnavailable(@NotNull GuildUnavailableEvent event) {
        GuildUnavailableEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> UnavailableGuildJoinedEventRules = new HashMap<>();

    @Override
    public void onUnavailableGuildJoined(@NotNull UnavailableGuildJoinedEvent event) {
        UnavailableGuildJoinedEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> UnavailableGuildLeaveEventRules = new HashMap<>();

    @Override
    public void onUnavailableGuildLeave(@NotNull UnavailableGuildLeaveEvent event) {
        UnavailableGuildLeaveEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildBanEventRules = new HashMap<>();

    @Override
    public void onGuildBan(@NotNull GuildBanEvent event) {
        GuildBanEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUnbanEventRules = new HashMap<>();

    @Override
    public void onGuildUnban(@NotNull GuildUnbanEvent event) {
        GuildUnbanEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildMemberRemoveEventRules = new HashMap<>();

    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
        GuildMemberRemoveEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateAfkChannelEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateAfkChannel(@NotNull GuildUpdateAfkChannelEvent event) {
        GuildUpdateAfkChannelEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateSystemChannelEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateSystemChannel(@NotNull GuildUpdateSystemChannelEvent event) {
        GuildUpdateSystemChannelEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateRulesChannelEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateRulesChannel(@NotNull GuildUpdateRulesChannelEvent event) {
        GuildUpdateRulesChannelEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateCommunityUpdatesChannelEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateCommunityUpdatesChannel(@NotNull GuildUpdateCommunityUpdatesChannelEvent event) {
        GuildUpdateCommunityUpdatesChannelEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateAfkTimeoutEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateAfkTimeout(@NotNull GuildUpdateAfkTimeoutEvent event) {
        GuildUpdateAfkTimeoutEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateExplicitContentLevelEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateExplicitContentLevel(@NotNull GuildUpdateExplicitContentLevelEvent event) {
        GuildUpdateExplicitContentLevelEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateIconEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateIcon(@NotNull GuildUpdateIconEvent event) {
        GuildUpdateIconEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateMFALevelEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateMFALevel(@NotNull GuildUpdateMFALevelEvent event) {
        GuildUpdateMFALevelEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateNameEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateName(@NotNull GuildUpdateNameEvent event) {
        GuildUpdateNameEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateNotificationLevelEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateNotificationLevel(@NotNull GuildUpdateNotificationLevelEvent event) {
        GuildUpdateNotificationLevelEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateOwnerEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateOwner(@NotNull GuildUpdateOwnerEvent event) {
        GuildUpdateOwnerEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateRegionEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateRegion(@NotNull GuildUpdateRegionEvent event) {
        GuildUpdateRegionEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateSplashEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateSplash(@NotNull GuildUpdateSplashEvent event) {
        GuildUpdateSplashEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateVerificationLevelEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateVerificationLevel(@NotNull GuildUpdateVerificationLevelEvent event) {
        GuildUpdateVerificationLevelEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateLocaleEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateLocale(@NotNull GuildUpdateLocaleEvent event) {
        GuildUpdateLocaleEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateFeaturesEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateFeatures(@NotNull GuildUpdateFeaturesEvent event) {
        GuildUpdateFeaturesEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateVanityCodeEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateVanityCode(@NotNull GuildUpdateVanityCodeEvent event) {
        GuildUpdateVanityCodeEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateBannerEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateBanner(@NotNull GuildUpdateBannerEvent event) {
        GuildUpdateBannerEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateDescriptionEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateDescription(@NotNull GuildUpdateDescriptionEvent event) {
        GuildUpdateDescriptionEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateBoostTierEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateBoostTier(@NotNull GuildUpdateBoostTierEvent event) {
        GuildUpdateBoostTierEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateBoostCountEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateBoostCount(@NotNull GuildUpdateBoostCountEvent event) {
        GuildUpdateBoostCountEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateMaxMembersEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateMaxMembers(@NotNull GuildUpdateMaxMembersEvent event) {
        GuildUpdateMaxMembersEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildUpdateMaxPresencesEventRules = new HashMap<>();

    @Override
    public void onGuildUpdateMaxPresences(@NotNull GuildUpdateMaxPresencesEvent event) {
        GuildUpdateMaxPresencesEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildInviteCreateEventRules = new HashMap<>();

    @Override
    public void onGuildInviteCreate(@NotNull GuildInviteCreateEvent event) {
        GuildInviteCreateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildInviteDeleteEventRules = new HashMap<>();

    @Override
    public void onGuildInviteDelete(@NotNull GuildInviteDeleteEvent event) {
        GuildInviteDeleteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildMemberJoinEventRules = new HashMap<>();

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        GuildMemberJoinEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildMemberRoleAddEventRules = new HashMap<>();

    @Override
    public void onGuildMemberRoleAdd(@NotNull GuildMemberRoleAddEvent event) {
        GuildMemberRoleAddEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildMemberRoleRemoveEventRules = new HashMap<>();

    @Override
    public void onGuildMemberRoleRemove(@NotNull GuildMemberRoleRemoveEvent event) {
        GuildMemberRoleRemoveEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildMemberUpdateEventRules = new HashMap<>();

    @Override
    public void onGuildMemberUpdate(@NotNull GuildMemberUpdateEvent event) {
        GuildMemberUpdateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildMemberUpdateNicknameEventRules = new HashMap<>();

    @Override
    public void onGuildMemberUpdateNickname(@NotNull GuildMemberUpdateNicknameEvent event) {
        GuildMemberUpdateNicknameEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildMemberUpdateBoostTimeEventRules = new HashMap<>();

    @Override
    public void onGuildMemberUpdateBoostTime(@NotNull GuildMemberUpdateBoostTimeEvent event) {
        GuildMemberUpdateBoostTimeEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildMemberUpdatePendingEventRules = new HashMap<>();

    @Override
    public void onGuildMemberUpdatePending(@NotNull GuildMemberUpdatePendingEvent event) {
        GuildMemberUpdatePendingEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildVoiceUpdateEventRules = new HashMap<>();

    @Override
    public void onGuildVoiceUpdate(@NotNull GuildVoiceUpdateEvent event) {
        GuildVoiceUpdateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildVoiceJoinEventRules = new HashMap<>();

    @Override
    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event) {
        GuildVoiceJoinEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildVoiceMoveEventRules = new HashMap<>();

    @Override
    public void onGuildVoiceMove(@NotNull GuildVoiceMoveEvent event) {
        GuildVoiceMoveEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildVoiceLeaveEventRules = new HashMap<>();

    @Override
    public void onGuildVoiceLeave(@NotNull GuildVoiceLeaveEvent event) {
        GuildVoiceLeaveEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildVoiceMuteEventRules = new HashMap<>();

    @Override
    public void onGuildVoiceMute(@NotNull GuildVoiceMuteEvent event) {
        GuildVoiceMuteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildVoiceDeafenEventRules = new HashMap<>();

    @Override
    public void onGuildVoiceDeafen(@NotNull GuildVoiceDeafenEvent event) {
        GuildVoiceDeafenEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildVoiceGuildMuteEventRules = new HashMap<>();

    @Override
    public void onGuildVoiceGuildMute(@NotNull GuildVoiceGuildMuteEvent event) {
        GuildVoiceGuildMuteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildVoiceGuildDeafenEventRules = new HashMap<>();

    @Override
    public void onGuildVoiceGuildDeafen(@NotNull GuildVoiceGuildDeafenEvent event) {
        GuildVoiceGuildDeafenEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildVoiceSelfMuteEventRules = new HashMap<>();

    @Override
    public void onGuildVoiceSelfMute(@NotNull GuildVoiceSelfMuteEvent event) {
        GuildVoiceSelfMuteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildVoiceSelfDeafenEventRules = new HashMap<>();

    @Override
    public void onGuildVoiceSelfDeafen(@NotNull GuildVoiceSelfDeafenEvent event) {
        GuildVoiceSelfDeafenEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildVoiceSuppressEventRules = new HashMap<>();

    @Override
    public void onGuildVoiceSuppress(@NotNull GuildVoiceSuppressEvent event) {
        GuildVoiceSuppressEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GuildVoiceStreamEventRules = new HashMap<>();

    @Override
    public void onGuildVoiceStream(@NotNull GuildVoiceStreamEvent event) {
        GuildVoiceStreamEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> RoleCreateEventRules = new HashMap<>();

    @Override
    public void onRoleCreate(@NotNull RoleCreateEvent event) {
        RoleCreateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> RoleDeleteEventRules = new HashMap<>();

    @Override
    public void onRoleDelete(@NotNull RoleDeleteEvent event) {
        RoleDeleteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> RoleUpdateColorEventRules = new HashMap<>();

    @Override
    public void onRoleUpdateColor(@NotNull RoleUpdateColorEvent event) {
        RoleUpdateColorEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> RoleUpdateHoistedEventRules = new HashMap<>();

    @Override
    public void onRoleUpdateHoisted(@NotNull RoleUpdateHoistedEvent event) {
        RoleUpdateHoistedEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> RoleUpdateMentionableEventRules = new HashMap<>();

    @Override
    public void onRoleUpdateMentionable(@NotNull RoleUpdateMentionableEvent event) {
        RoleUpdateMentionableEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> RoleUpdateNameEventRules = new HashMap<>();

    @Override
    public void onRoleUpdateName(@NotNull RoleUpdateNameEvent event) {
        RoleUpdateNameEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> RoleUpdatePermissionsEventRules = new HashMap<>();

    @Override
    public void onRoleUpdatePermissions(@NotNull RoleUpdatePermissionsEvent event) {
        RoleUpdatePermissionsEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> RoleUpdatePositionEventRules = new HashMap<>();

    @Override
    public void onRoleUpdatePosition(@NotNull RoleUpdatePositionEvent event) {
        RoleUpdatePositionEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> EmoteAddedEventRules = new HashMap<>();

    @Override
    public void onEmoteAdded(@NotNull EmoteAddedEvent event) {
        EmoteAddedEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> EmoteRemovedEventRules = new HashMap<>();

    @Override
    public void onEmoteRemoved(@NotNull EmoteRemovedEvent event) {
        EmoteRemovedEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> EmoteUpdateNameEventRules = new HashMap<>();

    @Override
    public void onEmoteUpdateName(@NotNull EmoteUpdateNameEvent event) {
        EmoteUpdateNameEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> EmoteUpdateRolesEventRules = new HashMap<>();

    @Override
    public void onEmoteUpdateRoles(@NotNull EmoteUpdateRolesEvent event) {
        EmoteUpdateRolesEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> HttpRequestEventRules = new HashMap<>();

    @Override
    public void onHttpRequest(@NotNull HttpRequestEvent event) {
        HttpRequestEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericApplicationCommandEventRules = new HashMap<>();

    @Override
    public void onGenericApplicationCommand(@NotNull GenericApplicationCommandEvent event) {
        GenericApplicationCommandEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericInteractionCreateEventRules = new HashMap<>();

    @Override
    public void onGenericInteractionCreate(@NotNull GenericInteractionCreateEvent event) {
        GenericInteractionCreateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericMessageEventRules = new HashMap<>();

    @Override
    public void onGenericMessage(@NotNull GenericMessageEvent event) {
        GenericMessageEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericMessageReactionEventRules = new HashMap<>();

    @Override
    public void onGenericMessageReaction(@NotNull GenericMessageReactionEvent event) {
        GenericMessageReactionEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericGuildMessageEventRules = new HashMap<>();

    @Override
    public void onGenericGuildMessage(@NotNull GenericGuildMessageEvent event) {
        GenericGuildMessageEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericGuildMessageReactionEventRules = new HashMap<>();

    @Override
    public void onGenericGuildMessageReaction(@NotNull GenericGuildMessageReactionEvent event) {
        GenericGuildMessageReactionEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericPrivateMessageEventRules = new HashMap<>();

    @Override
    public void onGenericPrivateMessage(@NotNull GenericPrivateMessageEvent event) {
        GenericPrivateMessageEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericPrivateMessageReactionEventRules = new HashMap<>();

    @Override
    public void onGenericPrivateMessageReaction(@NotNull GenericPrivateMessageReactionEvent event) {
        GenericPrivateMessageReactionEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericUserEventRules = new HashMap<>();

    @Override
    public void onGenericUser(@NotNull GenericUserEvent event) {
        GenericUserEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericUserPresenceEventRules = new HashMap<>();

    @Override
    public void onGenericUserPresence(@NotNull GenericUserPresenceEvent event) {
        GenericUserPresenceEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericSelfUpdateEventRules = new HashMap<>();

    @Override
    public void onGenericSelfUpdate(@NotNull GenericSelfUpdateEvent event) {
        GenericSelfUpdateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericStoreChannelEventRules = new HashMap<>();

    @Override
    public void onGenericStoreChannel(@NotNull GenericStoreChannelEvent event) {
        GenericStoreChannelEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericStoreChannelUpdateEventRules = new HashMap<>();

    @Override
    public void onGenericStoreChannelUpdate(@NotNull GenericStoreChannelUpdateEvent event) {
        GenericStoreChannelUpdateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericTextChannelEventRules = new HashMap<>();

    @Override
    public void onGenericTextChannel(@NotNull GenericTextChannelEvent event) {
        GenericTextChannelEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericTextChannelUpdateEventRules = new HashMap<>();

    @Override
    public void onGenericTextChannelUpdate(@NotNull GenericTextChannelUpdateEvent event) {
        GenericTextChannelUpdateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericVoiceChannelEventRules = new HashMap<>();

    @Override
    public void onGenericVoiceChannel(@NotNull GenericVoiceChannelEvent event) {
        GenericVoiceChannelEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericVoiceChannelUpdateEventRules = new HashMap<>();

    @Override
    public void onGenericVoiceChannelUpdate(@NotNull GenericVoiceChannelUpdateEvent event) {
        GenericVoiceChannelUpdateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericCategoryEventRules = new HashMap<>();

    @Override
    public void onGenericCategory(@NotNull GenericCategoryEvent event) {
        GenericCategoryEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericCategoryUpdateEventRules = new HashMap<>();

    @Override
    public void onGenericCategoryUpdate(@NotNull GenericCategoryUpdateEvent event) {
        GenericCategoryUpdateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericGuildEventRules = new HashMap<>();

    @Override
    public void onGenericGuild(@NotNull GenericGuildEvent event) {
        GenericGuildEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericGuildUpdateEventRules = new HashMap<>();

    @Override
    public void onGenericGuildUpdate(@NotNull GenericGuildUpdateEvent event) {
        GenericGuildUpdateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericGuildInviteEventRules = new HashMap<>();

    @Override
    public void onGenericGuildInvite(@NotNull GenericGuildInviteEvent event) {
        GenericGuildInviteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericGuildMemberEventRules = new HashMap<>();

    @Override
    public void onGenericGuildMember(@NotNull GenericGuildMemberEvent event) {
        GenericGuildMemberEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericGuildMemberUpdateEventRules = new HashMap<>();

    @Override
    public void onGenericGuildMemberUpdate(@NotNull GenericGuildMemberUpdateEvent event) {
        GenericGuildMemberUpdateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericGuildVoiceEventRules = new HashMap<>();

    @Override
    public void onGenericGuildVoice(@NotNull GenericGuildVoiceEvent event) {
        GenericGuildVoiceEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericRoleEventRules = new HashMap<>();

    @Override
    public void onGenericRole(@NotNull GenericRoleEvent event) {
        GenericRoleEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericRoleUpdateEventRules = new HashMap<>();

    @Override
    public void onGenericRoleUpdate(@NotNull GenericRoleUpdateEvent event) {
        GenericRoleUpdateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericEmoteEventRules = new HashMap<>();

    @Override
    public void onGenericEmote(@NotNull GenericEmoteEvent event) {
        GenericEmoteEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericEmoteUpdateEventRules = new HashMap<>();

    @Override
    public void onGenericEmoteUpdate(@NotNull GenericEmoteUpdateEvent event) {
        GenericEmoteUpdateEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }

    Map<Method, Object> GenericPermissionOverrideEventRules = new HashMap<>();

    @Override
    public void onGenericPermissionOverride(@NotNull GenericPermissionOverrideEvent event) {
        GenericPermissionOverrideEventRules.forEach((m,o)->{
            try {
                m.invoke(o, event);
            }catch(IllegalAccessException | InvocationTargetException e) {
                AtomicLogger.getInstance().warning("Rule invocation Failed: " + m.getDeclaringClass().getName()+"."+m.getName(),Priority.VERY_IMPORTANT);
            }
        });
    }
}
