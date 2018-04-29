# CoinsAPI
This is our CoinsAPI.

How-to-use
1. Import HashCodeDev-CoinsAPI.jar as an API into your project.
2. Add this line to your plugin.yml: depend: [HashCodeDev-CoinsAPI]
2. Start using our API!

Methods

//This will add the specified amount of coins to our player:
void addCoins(UUID, int);

//This will remove the specified amount of coins from our player:
void removeCoins(UUID, int);

//This will reset the coins of our player to zero and it will add him the specified amount of coins:
void setCoins(UUID, int);

//This will remove the specified amount of coins from the first UUID and add it to the second UUID:
void payCoins(UUID, UUID, int);

//This will return the amount of coins from our player:
int getCoins(UUID);

//This will return true if our player has the specified amount of coins:
boolean hasCoins(UUID, int);
