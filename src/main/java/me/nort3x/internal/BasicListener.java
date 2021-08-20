package me.nort3x.internal;

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
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BasicListener extends ListenerAdapter {

    private final Map<Class<?>, Set<InvokableRule>> parameterTypeToMethods = new ConcurrentHashMap<>();


        public boolean addRule(Method m, Object o) {
        Parameter[] parameters = m.getParameters();
        if (parameters.length != 1) {
            AtomicLogger.getInstance().warning("Rule should Only have one Parameter of Event Type, Rule : " + m.getDeclaringClass().getName() + "." + m.getName() + " is Rejected", Priority.VERY_IMPORTANT);
            return false;
        }
        Class<?> type = parameters[0].getType();
        parameterTypeToMethods.computeIfAbsent(parameters[0].getType(),x->ConcurrentHashMap.newKeySet()).add(new InvokableRule(m,o));
        return true;
    }


    @Override
    public void onTextChannelUpdatePermissions(@NotNull TextChannelUpdatePermissionsEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onStoreChannelUpdatePermissions(@NotNull StoreChannelUpdatePermissionsEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onVoiceChannelUpdatePermissions(@NotNull VoiceChannelUpdatePermissionsEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onCategoryUpdatePermissions(@NotNull CategoryUpdatePermissionsEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildMemberLeave(@NotNull GuildMemberLeaveEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onResume(@NotNull ResumedEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onReconnect(@NotNull ReconnectedEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericEvent(@NotNull GenericEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericUpdate(@NotNull UpdateEvent<?, ?> event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onRawGateway(@NotNull RawGatewayEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGatewayPing(@NotNull GatewayPingEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onResumed(@NotNull ResumedEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onReconnected(@NotNull ReconnectedEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onDisconnect(@NotNull DisconnectEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onShutdown(@NotNull ShutdownEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onStatusChange(@NotNull StatusChangeEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onException(@NotNull ExceptionEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onSlashCommand(@NotNull SlashCommandEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onButtonClick(@NotNull ButtonClickEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onApplicationCommandUpdate(@NotNull ApplicationCommandUpdateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onApplicationCommandDelete(@NotNull ApplicationCommandDeleteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onApplicationCommandCreate(@NotNull ApplicationCommandCreateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onUserUpdateName(@NotNull UserUpdateNameEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onUserUpdateDiscriminator(@NotNull UserUpdateDiscriminatorEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onUserUpdateAvatar(@NotNull UserUpdateAvatarEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onUserUpdateOnlineStatus(@NotNull UserUpdateOnlineStatusEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onUserUpdateActivityOrder(@NotNull UserUpdateActivityOrderEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onUserUpdateFlags(@NotNull UserUpdateFlagsEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onUserTyping(@NotNull UserTypingEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onUserActivityStart(@NotNull UserActivityStartEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onUserActivityEnd(@NotNull UserActivityEndEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onUserUpdateActivities(@NotNull UserUpdateActivitiesEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onSelfUpdateAvatar(@NotNull SelfUpdateAvatarEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onSelfUpdateMFA(@NotNull SelfUpdateMFAEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onSelfUpdateName(@NotNull SelfUpdateNameEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onSelfUpdateVerified(@NotNull SelfUpdateVerifiedEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildMessageUpdate(@NotNull GuildMessageUpdateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildMessageDelete(@NotNull GuildMessageDeleteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildMessageEmbed(@NotNull GuildMessageEmbedEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildMessageReactionAdd(@NotNull GuildMessageReactionAddEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildMessageReactionRemove(@NotNull GuildMessageReactionRemoveEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildMessageReactionRemoveAll(@NotNull GuildMessageReactionRemoveAllEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildMessageReactionRemoveEmote(@NotNull GuildMessageReactionRemoveEmoteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onPrivateMessageReceived(@NotNull PrivateMessageReceivedEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onPrivateMessageUpdate(@NotNull PrivateMessageUpdateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onPrivateMessageDelete(@NotNull PrivateMessageDeleteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onPrivateMessageEmbed(@NotNull PrivateMessageEmbedEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onPrivateMessageReactionAdd(@NotNull PrivateMessageReactionAddEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onPrivateMessageReactionRemove(@NotNull PrivateMessageReactionRemoveEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onMessageUpdate(@NotNull MessageUpdateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onMessageDelete(@NotNull MessageDeleteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onMessageBulkDelete(@NotNull MessageBulkDeleteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onMessageEmbed(@NotNull MessageEmbedEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onMessageReactionRemove(@NotNull MessageReactionRemoveEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onMessageReactionRemoveAll(@NotNull MessageReactionRemoveAllEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onMessageReactionRemoveEmote(@NotNull MessageReactionRemoveEmoteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onPermissionOverrideDelete(@NotNull PermissionOverrideDeleteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onPermissionOverrideUpdate(@NotNull PermissionOverrideUpdateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onPermissionOverrideCreate(@NotNull PermissionOverrideCreateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onStoreChannelDelete(@NotNull StoreChannelDeleteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onStoreChannelUpdateName(@NotNull StoreChannelUpdateNameEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onStoreChannelUpdatePosition(@NotNull StoreChannelUpdatePositionEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onStoreChannelCreate(@NotNull StoreChannelCreateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onTextChannelDelete(@NotNull TextChannelDeleteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onTextChannelUpdateName(@NotNull TextChannelUpdateNameEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onTextChannelUpdateTopic(@NotNull TextChannelUpdateTopicEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onTextChannelUpdatePosition(@NotNull TextChannelUpdatePositionEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onTextChannelUpdateNSFW(@NotNull TextChannelUpdateNSFWEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onTextChannelUpdateParent(@NotNull TextChannelUpdateParentEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onTextChannelUpdateSlowmode(@NotNull TextChannelUpdateSlowmodeEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onTextChannelUpdateNews(@NotNull TextChannelUpdateNewsEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onTextChannelCreate(@NotNull TextChannelCreateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onVoiceChannelDelete(@NotNull VoiceChannelDeleteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onVoiceChannelUpdateName(@NotNull VoiceChannelUpdateNameEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onVoiceChannelUpdatePosition(@NotNull VoiceChannelUpdatePositionEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onVoiceChannelUpdateUserLimit(@NotNull VoiceChannelUpdateUserLimitEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onVoiceChannelUpdateBitrate(@NotNull VoiceChannelUpdateBitrateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onVoiceChannelUpdateParent(@NotNull VoiceChannelUpdateParentEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onVoiceChannelUpdateRegion(@NotNull VoiceChannelUpdateRegionEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onVoiceChannelCreate(@NotNull VoiceChannelCreateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onCategoryDelete(@NotNull CategoryDeleteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onCategoryUpdateName(@NotNull CategoryUpdateNameEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onCategoryUpdatePosition(@NotNull CategoryUpdatePositionEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onCategoryCreate(@NotNull CategoryCreateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onPrivateChannelCreate(@NotNull PrivateChannelCreateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onPrivateChannelDelete(@NotNull PrivateChannelDeleteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildTimeout(@NotNull GuildTimeoutEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildLeave(@NotNull GuildLeaveEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildAvailable(@NotNull GuildAvailableEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUnavailable(@NotNull GuildUnavailableEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onUnavailableGuildJoined(@NotNull UnavailableGuildJoinedEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onUnavailableGuildLeave(@NotNull UnavailableGuildLeaveEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildBan(@NotNull GuildBanEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUnban(@NotNull GuildUnbanEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateAfkChannel(@NotNull GuildUpdateAfkChannelEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateSystemChannel(@NotNull GuildUpdateSystemChannelEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateRulesChannel(@NotNull GuildUpdateRulesChannelEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateCommunityUpdatesChannel(@NotNull GuildUpdateCommunityUpdatesChannelEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateAfkTimeout(@NotNull GuildUpdateAfkTimeoutEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateExplicitContentLevel(@NotNull GuildUpdateExplicitContentLevelEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateIcon(@NotNull GuildUpdateIconEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateMFALevel(@NotNull GuildUpdateMFALevelEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateName(@NotNull GuildUpdateNameEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateNotificationLevel(@NotNull GuildUpdateNotificationLevelEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateOwner(@NotNull GuildUpdateOwnerEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateRegion(@NotNull GuildUpdateRegionEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateSplash(@NotNull GuildUpdateSplashEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateVerificationLevel(@NotNull GuildUpdateVerificationLevelEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateLocale(@NotNull GuildUpdateLocaleEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateFeatures(@NotNull GuildUpdateFeaturesEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateVanityCode(@NotNull GuildUpdateVanityCodeEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateBanner(@NotNull GuildUpdateBannerEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateDescription(@NotNull GuildUpdateDescriptionEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateBoostTier(@NotNull GuildUpdateBoostTierEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateBoostCount(@NotNull GuildUpdateBoostCountEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateMaxMembers(@NotNull GuildUpdateMaxMembersEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildUpdateMaxPresences(@NotNull GuildUpdateMaxPresencesEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildInviteCreate(@NotNull GuildInviteCreateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildInviteDelete(@NotNull GuildInviteDeleteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildMemberRoleAdd(@NotNull GuildMemberRoleAddEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildMemberRoleRemove(@NotNull GuildMemberRoleRemoveEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildMemberUpdate(@NotNull GuildMemberUpdateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildMemberUpdateNickname(@NotNull GuildMemberUpdateNicknameEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildMemberUpdateBoostTime(@NotNull GuildMemberUpdateBoostTimeEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildMemberUpdatePending(@NotNull GuildMemberUpdatePendingEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildVoiceUpdate(@NotNull GuildVoiceUpdateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildVoiceMove(@NotNull GuildVoiceMoveEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildVoiceLeave(@NotNull GuildVoiceLeaveEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildVoiceMute(@NotNull GuildVoiceMuteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildVoiceDeafen(@NotNull GuildVoiceDeafenEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildVoiceGuildMute(@NotNull GuildVoiceGuildMuteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildVoiceGuildDeafen(@NotNull GuildVoiceGuildDeafenEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildVoiceSelfMute(@NotNull GuildVoiceSelfMuteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildVoiceSelfDeafen(@NotNull GuildVoiceSelfDeafenEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildVoiceSuppress(@NotNull GuildVoiceSuppressEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGuildVoiceStream(@NotNull GuildVoiceStreamEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onRoleCreate(@NotNull RoleCreateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onRoleDelete(@NotNull RoleDeleteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onRoleUpdateColor(@NotNull RoleUpdateColorEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onRoleUpdateHoisted(@NotNull RoleUpdateHoistedEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onRoleUpdateMentionable(@NotNull RoleUpdateMentionableEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onRoleUpdateName(@NotNull RoleUpdateNameEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onRoleUpdatePermissions(@NotNull RoleUpdatePermissionsEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onRoleUpdatePosition(@NotNull RoleUpdatePositionEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onEmoteAdded(@NotNull EmoteAddedEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onEmoteRemoved(@NotNull EmoteRemovedEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onEmoteUpdateName(@NotNull EmoteUpdateNameEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onEmoteUpdateRoles(@NotNull EmoteUpdateRolesEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onHttpRequest(@NotNull HttpRequestEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericApplicationCommand(@NotNull GenericApplicationCommandEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericInteractionCreate(@NotNull GenericInteractionCreateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericMessage(@NotNull GenericMessageEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericMessageReaction(@NotNull GenericMessageReactionEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericGuildMessage(@NotNull GenericGuildMessageEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericGuildMessageReaction(@NotNull GenericGuildMessageReactionEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericPrivateMessage(@NotNull GenericPrivateMessageEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericPrivateMessageReaction(@NotNull GenericPrivateMessageReactionEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericUser(@NotNull GenericUserEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericUserPresence(@NotNull GenericUserPresenceEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericSelfUpdate(@NotNull GenericSelfUpdateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericStoreChannel(@NotNull GenericStoreChannelEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericStoreChannelUpdate(@NotNull GenericStoreChannelUpdateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericTextChannel(@NotNull GenericTextChannelEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericTextChannelUpdate(@NotNull GenericTextChannelUpdateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericVoiceChannel(@NotNull GenericVoiceChannelEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericVoiceChannelUpdate(@NotNull GenericVoiceChannelUpdateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericCategory(@NotNull GenericCategoryEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericCategoryUpdate(@NotNull GenericCategoryUpdateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericGuild(@NotNull GenericGuildEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericGuildUpdate(@NotNull GenericGuildUpdateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericGuildInvite(@NotNull GenericGuildInviteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericGuildMember(@NotNull GenericGuildMemberEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericGuildMemberUpdate(@NotNull GenericGuildMemberUpdateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericGuildVoice(@NotNull GenericGuildVoiceEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericRole(@NotNull GenericRoleEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericRoleUpdate(@NotNull GenericRoleUpdateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericEmote(@NotNull GenericEmoteEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericEmoteUpdate(@NotNull GenericEmoteUpdateEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }

    @Override
    public void onGenericPermissionOverride(@NotNull GenericPermissionOverrideEvent event) {
        Optional.ofNullable(parameterTypeToMethods.getOrDefault(event.getClass(), null))
                .ifPresent(set->
                    set.parallelStream().forEach(invokableRule -> invokableRule.invoke(event))
                );
    }
}
