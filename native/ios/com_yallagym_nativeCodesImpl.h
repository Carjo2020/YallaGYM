#import <Foundation/Foundation.h>

@interface com_yallagym_nativeCodesImpl : NSObject {
}

-(void)enableGPS:(NSString*)param param1:(NSString*)param1;
-(void)enableGPSAPI;
-(void)turnGPSOn;
-(NSString*)getIosFcmToken;
-(void)turnGPSOff;
-(BOOL)isSupported;
@end
