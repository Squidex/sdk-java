package com.squidex.api.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = UsersDto.Builder.class)
public final class UsersDto implements IResource {
    private final Map<String, ResourceLink> links;

    private final int total;

    private final List<UserDto> items;

    private UsersDto(Map<String, ResourceLink> links, int total, List<UserDto> items) {
        this.links = links;
        this.total = total;
        this.items = items;
    }

    /**
     * @return The links.
     */
    @JsonProperty("_links")
    @Override
    public Map<String, ResourceLink> getLinks() {
        return links;
    }

    /**
     * @return The total number of users.
     */
    @JsonProperty("total")
    public int getTotal() {
        return total;
    }

    /**
     * @return The users.
     */
    @JsonProperty("items")
    public List<UserDto> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UsersDto && equalTo((UsersDto) other);
    }

    private boolean equalTo(UsersDto other) {
        return links.equals(other.links) && total == other.total && items.equals(other.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.links, this.total, this.items);
    }

    @Override
    public String toString() {
        return "UsersDto{" + "links: " + links + ", total: " + total + ", items: " + items + "}";
    }

    public static TotalStage builder() {
        return new Builder();
    }

    public interface TotalStage {
        _FinalStage total(int total);

        Builder from(UsersDto other);
    }

    public interface _FinalStage {
        UsersDto build();

        _FinalStage links(Map<String, ResourceLink> links);

        _FinalStage putAllLinks(Map<String, ResourceLink> links);

        _FinalStage links(String key, ResourceLink value);

        _FinalStage items(List<UserDto> items);

        _FinalStage addItems(UserDto items);

        _FinalStage addAllItems(List<UserDto> items);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TotalStage, _FinalStage {
        private int total;

        private List<UserDto> items = new ArrayList<>();

        private Map<String, ResourceLink> links = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(UsersDto other) {
            links(other.getLinks());
            total(other.getTotal());
            items(other.getItems());
            return this;
        }

        /**
         * <p>The total number of users.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("total")
        public _FinalStage total(int total) {
            this.total = total;
            return this;
        }

        /**
         * <p>The users.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllItems(List<UserDto> items) {
            this.items.addAll(items);
            return this;
        }

        /**
         * <p>The users.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addItems(UserDto items) {
            this.items.add(items);
            return this;
        }

        @Override
        @JsonSetter(value = "items", nulls = Nulls.SKIP)
        public _FinalStage items(List<UserDto> items) {
            this.items.clear();
            this.items.addAll(items);
            return this;
        }

        /**
         * <p>The links.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage links(String key, ResourceLink value) {
            this.links.put(key, value);
            return this;
        }

        /**
         * <p>The links.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage putAllLinks(Map<String, ResourceLink> links) {
            this.links.putAll(links);
            return this;
        }

        @Override
        @JsonSetter(value = "_links", nulls = Nulls.SKIP)
        public _FinalStage links(Map<String, ResourceLink> links) {
            this.links.clear();
            this.links.putAll(links);
            return this;
        }

        @Override
        public UsersDto build() {
            return new UsersDto(links, total, items);
        }
    }
}
