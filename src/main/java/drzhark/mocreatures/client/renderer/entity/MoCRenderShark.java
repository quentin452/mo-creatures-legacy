package drzhark.mocreatures.client.renderer.entity;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import drzhark.mocreatures.MoCreatures;
import drzhark.mocreatures.entity.aquatic.MoCEntityShark;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class MoCRenderShark extends RenderLiving {

    public MoCRenderShark(ModelBase modelBase, float f)
    {
        super(modelBase, f);
    }

    @Override
    public void doRender(EntityLiving entityLiving, double d, double d1, double d2, float f, float f1)
    {
        MoCEntityShark entityshark = (MoCEntityShark) entityLiving;
        super.doRender(entityshark, d, d1, d2, f, f1);
        boolean flag = MoCreatures.proxy.getDisplayPetName() && !(entityshark.getName()).isEmpty();
        boolean flag1 = MoCreatures.proxy.getDisplayPetHealth(entityLiving);
        boolean flag2 = MoCreatures.proxy.getDisplayPetIcons();
        if (entityshark.renderName())
        {
            float f2 = 1.6F;
            float f3 = 0.01666667F * f2;
            float f4 = entityshark.getDistanceToEntity(renderManager.livingPlayer);
            if (f4 < 16F)
            {
                String s = "";
                s = (new StringBuilder()).append(s).append(entityshark.getName()).toString();
                float f5 = 0.1F;
                FontRenderer fontrenderer = getFontRendererFromRenderManager();
                GL11.glPushMatrix();
                GL11.glTranslatef((float) d + 0.0F, (float) d1 + f5, (float) d2);
                GL11.glNormal3f(0.0F, 1.0F, 0.0F);
                GL11.glRotatef(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(-f3, -f3, f3);
                GL11.glDisable(2896 /* GL_LIGHTING */);
                Tessellator tessellator = Tessellator.instance;
                byte byte0 = -50;
                if (flag1)
                {
                    GL11.glDisable(3553 /* GL_TEXTURE_2D */);
                    if (!flag)
                    {
                        byte0 += 8;
                    }
                    tessellator.startDrawingQuads();
                    // might break SSP
                    float f6 = entityshark.getHealth();
                    float f7 = entityshark.getMaxHealth();
                    float f8 = f6 / f7;
                    float f9 = 40F * f8;
                    tessellator.setColorRGBA_F(0.7F, 0.0F, 0.0F, 1.0F);
                    tessellator.addVertex(-20F + f9, -10 + byte0, 0.0D);
                    tessellator.addVertex(-20F + f9, -6 + byte0, 0.0D);
                    tessellator.addVertex(20D, -6 + byte0, 0.0D);
                    tessellator.addVertex(20D, -10 + byte0, 0.0D);
                    tessellator.setColorRGBA_F(0.0F, 0.7F, 0.0F, 1.0F);
                    tessellator.addVertex(-20D, -10 + byte0, 0.0D);
                    tessellator.addVertex(-20D, -6 + byte0, 0.0D);
                    tessellator.addVertex(f9 - 20F, -6 + byte0, 0.0D);
                    tessellator.addVertex(f9 - 20F, -10 + byte0, 0.0D);
                    tessellator.draw();
                    GL11.glEnable(3553 /* GL_TEXTURE_2D */);
                }
                if (flag)
                {
                    GL11.glDepthMask(false);
                    GL11.glDisable(2929 /* GL_DEPTH_TEST */);
                    GL11.glEnable(3042 /* GL_BLEND */);
                    GL11.glBlendFunc(770, 771);
                    GL11.glDisable(3553 /* GL_TEXTURE_2D */);
                    tessellator.startDrawingQuads();
                    int i = fontrenderer.getStringWidth(s) / 2;
                    tessellator.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.25F);
                    tessellator.addVertex(-i - 1, -1 + byte0, 0.0D);
                    tessellator.addVertex(-i - 1, 8 + byte0, 0.0D);
                    tessellator.addVertex(i + 1, 8 + byte0, 0.0D);
                    tessellator.addVertex(i + 1, -1 + byte0, 0.0D);
                    tessellator.draw();
                    GL11.glEnable(3553 /* GL_TEXTURE_2D */);
                    fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, byte0, 0x20ffffff);
                    GL11.glEnable(2929 /* GL_DEPTH_TEST */);
                    GL11.glDepthMask(true);
                    fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, byte0, -1);
                    GL11.glDisable(3042 /* GL_BLEND */);
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                }
                GL11.glEnable(2896 /* GL_LIGHTING */);
                GL11.glPopMatrix();
            }
        }
    }

    public void doRender2(EntityLiving entityLiving, double d, double d1, double d2, float f, float f1)
    {
        MoCEntityShark entityshark = (MoCEntityShark) entityLiving;
        super.doRender(entityshark, d, d1, d2, f, f1);
        if (entityshark.renderName())
        {
            float f2 = 1.6F;
            float f3 = 0.01666667F * f2;
            float f4 = entityLiving.getDistanceToEntity(renderManager.livingPlayer);
            String s = "";
            s = (new StringBuilder()).append(s).append(entityshark.getName()).toString();
            if ((f4 < 12F) && (s.length() > 0))
            {
                FontRenderer fontrenderer = getFontRendererFromRenderManager();
                GL11.glPushMatrix();
                GL11.glTranslatef((float) d + 0.0F, (float) d1 + 0.2F, (float) d2);
                GL11.glNormal3f(0.0F, 1.0F, 0.0F);
                GL11.glRotatef(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(-f3, -f3, f3);
                GL11.glDisable(2896 /* GL_LIGHTING */);
                GL11.glDepthMask(false);
                GL11.glDisable(2929 /* GL_DEPTH_TEST */);
                GL11.glEnable(3042 /* GL_BLEND */);
                GL11.glBlendFunc(770, 771);
                Tessellator tessellator = Tessellator.instance;
                byte byte0 = -50;
                GL11.glDisable(3553 /* GL_TEXTURE_2D */);
                tessellator.startDrawingQuads();
                int i = fontrenderer.getStringWidth(s) / 2;
                tessellator.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.25F);
                tessellator.addVertex(-i - 1, -1 + byte0, 0.0D);
                tessellator.addVertex(-i - 1, 8 + byte0, 0.0D);
                tessellator.addVertex(i + 1, 8 + byte0, 0.0D);
                tessellator.addVertex(i + 1, -1 + byte0, 0.0D);
                if (MoCreatures.proxy.getDisplayPetHealth(entityLiving))
                {
                    float f5 = entityshark.getHealth();
                    float f6 = entityshark.getMaxHealth();
                    float f7 = f5 / f6;
                    float f8 = 40F * f7;
                    tessellator.setColorRGBA_F(0.7F, 0.0F, 0.0F, 1.0F);
                    tessellator.addVertex(-20F + f8, -10 + byte0, 0.0D);
                    tessellator.addVertex(-20F + f8, -6 + byte0, 0.0D);
                    tessellator.addVertex(20D, -6 + byte0, 0.0D);
                    tessellator.addVertex(20D, -10 + byte0, 0.0D);
                    tessellator.setColorRGBA_F(0.0F, 0.7F, 0.0F, 1.0F);
                    tessellator.addVertex(-20D, -10 + byte0, 0.0D);
                    tessellator.addVertex(-20D, -6 + byte0, 0.0D);
                    tessellator.addVertex(f8 - 20F, -6 + byte0, 0.0D);
                    tessellator.addVertex(f8 - 20F, -10 + byte0, 0.0D);
                }
                tessellator.draw();
                GL11.glEnable(3553 /* GL_TEXTURE_2D */);
                fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, byte0, 0x20ffffff);
                GL11.glEnable(2929 /* GL_DEPTH_TEST */);
                GL11.glDepthMask(true);
                fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, byte0, -1);
                GL11.glEnable(2896 /* GL_LIGHTING */);
                GL11.glDisable(3042 /* GL_BLEND */);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                GL11.glPopMatrix();
            }
        }
    }

    @Override
    protected float handleRotationFloat(EntityLivingBase entityLiving, float f)
    {
        stretch((MoCEntityShark) entityLiving);
        return entityLiving.ticksExisted + f;
    }

    protected void stretch(MoCEntityShark entityshark)
    {
        GL11.glScalef(entityshark.getMoCAge() * 0.01F, entityshark.getMoCAge() * 0.01F, entityshark.getMoCAge() * 0.01F);
    }

    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return ((MoCEntityShark)par1Entity).getTexture();
    }
}
