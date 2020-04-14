#import "com_yallagym_nativeCodesImpl.h"

@implementation com_yallagym_nativeCodesImpl

-(void)enableGPS:(NSString*)param param1:(NSString*)param1{
}

-(void)enableGPSAPI{
}

-(void)turnGPSOn{
}

-(NSString*)getIosFcmToken{
    return [[NSUserDefaults standardUserDefaults]stringForKey:@"fcm_token"];
}

-(void)turnGPSOff{
}

-(BOOL)isSupported{
    return YES;
}

@end
