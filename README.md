# GenshinWishSim

This is a simple Java console application meant to replicate Genshin Impact's character gacha system. It works as following:
- On a banner, there is a base chance of 0.6% to receive a 5-star character, 5.1% to receive a 4-star character, and 94.3% to get a 3-star weapon
- There are two types of banner: limited, and standard
- On the standard banner, only standard 5-star characters can be obtained
- On the limited banner, there will be one limited 5-star character, alongside the ones from standard
- The amount of pulls since the last 4-star and 5-star are tracked
- If it has been 10 pulls since the last 4-star or 5-star, a 4-star is guaranteed
- If it has been 90 pulls since the last 5-star, a 5-star is guaranteed (hard pity)
- If on a limited banner, a standard 5-star is pulled, the next 5-star is guaranteed to be the limited one for that banner
- At 75 pulls, the rate at which 4 and 5-stars appear is greatly increased (soft pity)

If duplicates of the same character are pulled, their constellation level is increased. The constellation levels range from 0 to 6, but the application tracks the amount of copies beyond that.
