# Music_streaming_app_backend
Music Streaming App  is a backend system designed to manage music streaming services for users. It enables users to browse, stream, and organize music into playlists, while maintaining comprehensive data about songs, artists, albums, playlists, and users. The system incorporates efficient data structures, scalability, and extensibility.

Entities and Attributes

Song Song ID (Unique Identifier) Title (String) Genre (String) Duration (Time) Release Date (Date) Album (Reference to Album) Artist(s) (Many-to-Many Relationship with Artist) Playlists (Many-to-Many Relationship with Playlist)

Artist Artist ID (Unique Identifier) Name (String) Biography (String) Birth Date (Date) Albums (One-to-Many Relationship with Album) Songs (Many-to-Many Relationship with Song)

Album Album ID (Unique Identifier) Title (String) Release Date (Date) Artist (One-to-One Relationship with Artist) Songs (One-to-Many Relationship with Song) Genre (String)

Playlist Playlist ID (Unique Identifier) Name (String) Description (String) Created By (Reference to User) Songs (Many-to-Many Relationship with Song)

User User ID (Unique Identifier) Name (String) Email (String) Password (Hashed String) Playlists (One-to-Many Relationship with Playlist)
